//
//  Copyright (c) 2015 VK.com
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to
//  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
//  the Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
//  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
//  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
//  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

package com.vk.sdk.payments;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.vk.sdk.VKUIHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

public final class VKIInAppBillingService {

    private static final String RECEIPT_DATA = "receipt_data";
    private static final String RECEIPT_VALUE = "price_value";
    private static final String RECEIPT_CURRENCY = "currency";
    private static final String RECEIPT_QUANTITY = "quantity";

    private static class Receipt {
        String receiptData;// native android receipt data
        float priceValue;// price of in-app
        String currency;// ISO 4217
        int quantity; // count of in-app

        String toJson() throws JSONException {
            JSONObject object = new JSONObject();

            if (!TextUtils.isEmpty(receiptData)) {
                object.put(RECEIPT_DATA, receiptData);
            }
            object.put(RECEIPT_VALUE, priceValue);

            if (!TextUtils.isEmpty(currency)) {
                object.put(RECEIPT_CURRENCY, currency);
            }

            object.put(RECEIPT_QUANTITY, quantity);
            return object.toString();
        }
    }

    private static class PurchaseData {
        String purchaseData = null;
        boolean hasError = false;
    }

    private static class SyncServiceConnection implements ServiceConnection {

        final Object syncObj = new Object();
        volatile boolean isFinish = false;

        @Override
        public final void onServiceConnected(ComponentName name, IBinder service) {
            synchronized (this.syncObj) {
                try {
                    onServiceConnectedImpl(name, service);
                } catch (Exception e) {
                    // nothing
                }
                isFinish = true;
                syncObj.notifyAll();
            }
        }

        @Override
        public final void onServiceDisconnected(ComponentName name) {
            synchronized (this.syncObj) {
                try {
                    onServiceDisconnectedImpl(name);
                } catch (Exception e) {
                    // nothing
                }
                isFinish = true;
                syncObj.notifyAll();
            }
        }

        public void onServiceConnectedImpl(ComponentName name, IBinder service) {
        }

        public void onServiceDisconnectedImpl(ComponentName name) {
        }
    }

    private static final String PARAMS_ARE_NOT_VALID_ERROR = "params of constructor don't implement com.android.vending.billing.IInAppBillingService";

    // some fields on the getSkuDetails response bundle
    private static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    private static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    private static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String PRODUCT_ID = "productId";

    private static final String SKU_DETAIL_AMOUNT_MICROS = "price_amount_micros";
    private static final String SKU_DETAIL_PRICE_CURRENCY_CODE = "price_currency_code";
    private static final String PURCHASE_DETAIL_TOKEN = "token";
    private static final String PURCHASE_DETAIL_PURCHASE_TOKEN = "purchaseToken";

    private final Object mIInAppBillingService;

    private static final Method sMethodIsBillingSupported;
    private static final Method sMethodGetSkuDetails;
    private static final Method sMethodGetBuyIntent;
    private static final Method sMethodGetPurchases;
    private static final Method sMethodConsumePurchase;

    static {
        Class<?> mIInAppBillingServiceClass;
        try {
            mIInAppBillingServiceClass = Class.forName("com.android.vending.billing.IInAppBillingService");

            sMethodIsBillingSupported = mIInAppBillingServiceClass.getMethod("isBillingSupported", int.class, String.class, String.class);
            sMethodGetSkuDetails = mIInAppBillingServiceClass.getMethod("getSkuDetails", int.class, String.class, String.class, Bundle.class);
            sMethodGetBuyIntent = mIInAppBillingServiceClass.getMethod("getBuyIntent", int.class, String.class, String.class, String.class, String.class);
            sMethodGetPurchases = mIInAppBillingServiceClass.getMethod("getPurchases", int.class, String.class, String.class, String.class);
            sMethodConsumePurchase = mIInAppBillingServiceClass.getMethod("consumePurchase", int.class, String.class, String.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(PARAMS_ARE_NOT_VALID_ERROR);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param iInAppBillingService implementation of com.android.vending.billing.IInAppBillingService
     */
    public VKIInAppBillingService(@NonNull Object iInAppBillingService) {
        this.mIInAppBillingService = iInAppBillingService;

        Class<?> mIInAppBillingServiceClass;
        try {
            mIInAppBillingServiceClass = Class.forName("com.android.vending.billing.IInAppBillingService");
            mIInAppBillingServiceClass.cast(mIInAppBillingService);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(PARAMS_ARE_NOT_VALID_ERROR);
        }
    }

    /**
     * Checks support for the requested billing API version, package and in-app type.
     * Minimum API version supported by this interface is 3.
     *
     * @param apiVersion  the billing version which the app is using
     * @param packageName the package name of the calling app
     * @param type        type of the in-app item being purchased "inapp" for one-time purchases
     *                    and "subs" for subscription.
     * @return RESULT_OK(0) on success, corresponding result code on failures
     */
    public int isBillingSupported(final int apiVersion,
                                  @NonNull final String packageName,
                                  @NonNull final String type) throws android.os.RemoteException {
        try {
            return (Integer) sMethodIsBillingSupported.invoke(mIInAppBillingService, apiVersion, packageName, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Provides details of a list of SKUs
     * Given a list of SKUs of a valid type in the skusBundle, this returns a bundle
     * with a list JSON strings containing the productId, price, title and description.
     * This API can be called with a maximum of 20 SKUs.
     *
     * @param apiVersion  billing API version that the Third-party is using
     * @param packageName the package name of the calling app
     * @param skusBundle  bundle containing a StringArrayList of SKUs with key "ITEM_ID_LIST"
     * @return Bundle containing the following key-value pairs
     * "RESPONSE_CODE" with int value, RESULT_OK(0) if success, other response codes on
     * failure as listed above.
     * "DETAILS_LIST" with a StringArrayList containing purchase information
     * in JSON format similar to:
     * '{ "productId" : "exampleSku", "type" : "inapp", "price" : "$5.00",
     * "title : "Example Title", "description" : "This is an example description" }'
     */
    public Bundle getSkuDetails(final int apiVersion,
                                @NonNull final String packageName,
                                @NonNull final String type,
                                @NonNull final Bundle skusBundle) throws android.os.RemoteException {
        return getSkuDetails(mIInAppBillingService, apiVersion, packageName, type, skusBundle);
    }

    private static Bundle getSkuDetails(@NonNull final Object iInAppBillingService,
                                        final int apiVersion,
                                        @NonNull final String packageName,
                                        @NonNull final String type,
                                        @NonNull final Bundle skusBundle) throws android.os.RemoteException {
        try {
            return (Bundle) sMethodGetSkuDetails.invoke(iInAppBillingService, apiVersion, packageName, type, skusBundle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a pending intent to launch the purchase flow for an in-app item by providing a SKU,
     * the type, a unique purchase token and an optional developer payload.
     *
     * @param apiVersion       billing API version that the app is using
     * @param packageName      package name of the calling app
     * @param sku              the SKU of the in-app item as published in the developer console
     * @param type             the type of the in-app item ("inapp" for one-time purchases
     *                         and "subs" for subscription).
     * @param developerPayload optional argument to be sent back with the purchase information
     * @return Bundle containing the following key-value pairs
     * "RESPONSE_CODE" with int value, RESULT_OK(0) if success, other response codes on
     * failure as listed above.
     * "BUY_INTENT" - PendingIntent to start the purchase flow
     * The Pending intent should be launched with startIntentSenderForResult. When purchase flow
     * has completed, the onActivityResult() will give a resultCode of OK or CANCELED.
     * If the purchase is successful, the result data will contain the following key-value pairs
     * "RESPONSE_CODE" with int value, RESULT_OK(0) if success, other response codes on
     * failure as listed above.
     * "INAPP_PURCHASE_DATA" - String in JSON format similar to
     * '{"orderId":"12999763169054705758.1371079406387615",
     * "packageName":"com.example.app",
     * "productId":"exampleSku",
     * "purchaseTime":1345678900000,
     * "purchaseToken" : "122333444455555",
     * "developerPayload":"example developer payload" }'
     * "INAPP_DATA_SIGNATURE" - String containing the signature of the purchase data that
     * was signed with the private key of the developer
     */
    public Bundle getBuyIntent(final int apiVersion,
                               @NonNull final String packageName,
                               @NonNull final String sku,
                               @NonNull final String type,
                               @NonNull String developerPayload) throws android.os.RemoteException {
        try {
            return (Bundle) sMethodGetBuyIntent.invoke(mIInAppBillingService, apiVersion, packageName, sku, type, developerPayload);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the current SKUs owned by the user of the type and package name specified along with
     * purchase information and a signature of the data to be validated.
     * This will return all SKUs that have been purchased in V3 and managed items purchased using
     * V1 and V2 that have not been consumed.
     *
     * @param apiVersion        billing API version that the app is using
     * @param packageName       package name of the calling app
     * @param type              the type of the in-app items being requested
     *                          ("inapp" for one-time purchases and "subs" for subscription).
     * @param continuationToken to be set as null for the first call, if the number of owned
     *                          skus are too many, a continuationToken is returned in the response bundle.
     *                          This method can be called again with the continuation token to get the next set of
     *                          owned skus.
     * @return Bundle containing the following key-value pairs
     * "RESPONSE_CODE" with int value, RESULT_OK(0) if success, other response codes on
     * failure as listed above.
     * "INAPP_PURCHASE_ITEM_LIST" - StringArrayList containing the list of SKUs
     * "INAPP_PURCHASE_DATA_LIST" - StringArrayList containing the purchase information
     * "INAPP_DATA_SIGNATURE_LIST"- StringArrayList containing the signatures
     * of the purchase information
     * "INAPP_CONTINUATION_TOKEN" - String containing a continuation token for the
     * next set of in-app purchases. Only set if the
     * user has more owned skus than the current list.
     */
    public Bundle getPurchases(final int apiVersion,
                               @NonNull final String packageName,
                               @NonNull final String type,
                               @NonNull final String continuationToken) throws android.os.RemoteException {
        return getPurchases(mIInAppBillingService, apiVersion, packageName, type, continuationToken);
    }

    private static Bundle getPurchases(@NonNull final Object iInAppBillingService,
                                       final int apiVersion,
                                       @NonNull final String packageName,
                                       @NonNull final String type,
                                       @NonNull final String continuationToken) throws android.os.RemoteException {
        try {
            return (Bundle) sMethodGetPurchases.invoke(iInAppBillingService, apiVersion, packageName, type, continuationToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Consume the last purchase of the given SKU. This will result in this item being removed
     * from all subsequent responses to getPurchases() and allow re-purchase of this item.
     *
     * @param apiVersion    billing API version that the app is using
     * @param packageName   package name of the calling app
     * @param purchaseToken token in the purchase information JSON that identifies the purchase
     *                      to be consumed
     * @return 0 if consumption succeeded. Appropriate error values for failures.
     */
    public int consumePurchase(final int apiVersion,
                               @NonNull final String packageName,
                               @NonNull final String purchaseToken) throws android.os.RemoteException {
        String purchaseData = !VKPaymentsServerSender.isNotVkUser() //
                ? getPurchaseData(mIInAppBillingService, apiVersion, packageName, purchaseToken) //
                : null;

        int result;
        try {
            result = (Integer) sMethodConsumePurchase.invoke(mIInAppBillingService, apiVersion, packageName, purchaseToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        final Context ctx = VKUIHelper.getApplicationContext();
        if (!TextUtils.isEmpty(purchaseData) && ctx != null) {
            VKPaymentsServerSender.getInstance(ctx).saveTransaction(purchaseData);
        }

        return result;
    }

    // ---------- STATIC METHODS ----------

    /**
     * Method for save transaction if you can't use
     * VKIInAppBillingService mService = new VKIInAppBillingService(IInAppBillingService.Stub.asInterface(service));
     * WARNING!!! this method must call before consume google and is it returned true
     *
     * @param apiVersion - version google apis
     * @param purchaseToken - purchase token
     * @return true is send is ok
     * @throws android.os.RemoteException
     */
    public static boolean consumePurchaseToVk(final int apiVersion,
                                              @NonNull final String purchaseToken) throws android.os.RemoteException {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new RuntimeException("Network on main thread");
        }
        final Context ctx = VKUIHelper.getApplicationContext();
        if (ctx == null) {
            return false;
        }

        final PurchaseData purchaseData = new PurchaseData();

        if (!VKPaymentsServerSender.isNotVkUser()) {
            final SyncServiceConnection serviceConnection = new SyncServiceConnection() {
                @Override
                public void onServiceConnectedImpl(ComponentName name, IBinder service) {
                    Object iInAppBillingService = null;

                    final Class<?> iInAppBillingServiceClassStub;
                    try {
                        iInAppBillingServiceClassStub = Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                        Method asInterface = iInAppBillingServiceClassStub.getMethod("asInterface", android.os.IBinder.class);
                        iInAppBillingService = asInterface.invoke(iInAppBillingServiceClassStub, service);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(PARAMS_ARE_NOT_VALID_ERROR);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        purchaseData.purchaseData = getPurchaseData(iInAppBillingService, apiVersion, ctx.getPackageName(), purchaseToken);
                    } catch (Exception e) {
                        Log.e("VKSDK", "error", e);
                        purchaseData.hasError = true;
                    }
                }

                @Override
                public void onServiceDisconnectedImpl(ComponentName name) {

                }
            };

            Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            serviceIntent.setPackage("com.android.vending");
            if (!ctx.getPackageManager().queryIntentServices(serviceIntent, 0).isEmpty()) {
                // bind
                ctx.bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                // wait bind
                synchronized (serviceConnection.syncObj) {
                    while (!serviceConnection.isFinish) {
                        try {
                            serviceConnection.syncObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                // unbind
                ctx.unbindService(serviceConnection);
            } else {
                return false;
            }
        } else {
            return true;
        }

        if (purchaseData.hasError) {
            return false;
        } else if (!TextUtils.isEmpty(purchaseData.purchaseData)) {
            VKPaymentsServerSender.getInstance(ctx).saveTransaction(purchaseData.purchaseData);
        }

        return true;
    }

    // ---------- PRIVATE METHODS ----------

    private static String getPurchaseData(@NonNull final Object iInAppBillingService,
                                          final int apiVersion,
                                          @NonNull final String packageName,
                                          @NonNull final String purchaseToken) throws RemoteException {
        Bundle ownedItems = getPurchases(iInAppBillingService, apiVersion, packageName, "inapp", purchaseToken);
        ArrayList<String> purchaseDataList = ownedItems.getStringArrayList(RESPONSE_INAPP_PURCHASE_DATA_LIST);
        if (purchaseDataList != null) {
            for (int i = 0; i < purchaseDataList.size(); ++i) {
                String purchaseDataLocal = purchaseDataList.get(i);
                try {
                    JSONObject o = new JSONObject(purchaseDataLocal);
                    String token = o.optString(PURCHASE_DETAIL_TOKEN, o.optString(PURCHASE_DETAIL_PURCHASE_TOKEN));
                    if (TextUtils.equals(purchaseToken, token)) {
                        return getReceipt(iInAppBillingService, apiVersion, packageName, purchaseDataLocal).toJson();
                    }
                } catch (JSONException e) {
                    // nothing
                }
            }
        }
        return null;
    }

    private static Receipt getReceipt(@NonNull final Object iInAppBillingService,
                                      final int apiVersion,
                                      @NonNull final String packageName,
                                      @NonNull final String receiptOriginal) throws JSONException, RemoteException {
        JSONObject objectReceipt = new JSONObject(receiptOriginal);

        Receipt receipt = new Receipt();
        receipt.receiptData = receiptOriginal;
        receipt.quantity = 1;

        String sku = objectReceipt.getString(PRODUCT_ID);

        ArrayList<String> skuList = new ArrayList<>();
        skuList.add(sku);

        Bundle queryBundle = new Bundle();
        queryBundle.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, skuList);
        Bundle responseBundle = getSkuDetails(iInAppBillingService, apiVersion, packageName, "inapp", queryBundle);

        ArrayList<String> responseList = responseBundle.getStringArrayList(RESPONSE_GET_SKU_DETAILS_LIST);
        if (responseList != null && !responseList.isEmpty()) {
            try {
                JSONObject object = new JSONObject(responseList.get(0));
                receipt.priceValue = Float.parseFloat(object.optString(SKU_DETAIL_AMOUNT_MICROS)) / 1000000f;
                receipt.currency = object.optString(SKU_DETAIL_PRICE_CURRENCY_CODE);
            } catch (JSONException e) {
                // nothing
            }
        }
        return receipt;
    }
}