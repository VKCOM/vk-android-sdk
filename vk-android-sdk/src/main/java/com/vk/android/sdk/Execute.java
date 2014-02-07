package com.vk.android.sdk;

/**
 * Allows to send execute procedures. <br/>
 * <b>Note</b>: this method requires authorization
 * @see <a href="http://vk.com/dev/execute">http://vk.com/dev/execute</a>
 * @param <T> result type
 */
public abstract class Execute<T> extends VKRequest<T> {

    /**
     * Created execute procedure
     * @param code code for execute with placeholders like in {@link String#format(String, Object...)} method.
     * @param args arguments to replace in the @{code code}.
     */
    public Execute(String code, Object... args) {
        super("execute");
        param("code", String.format(code, args));
    }

}
