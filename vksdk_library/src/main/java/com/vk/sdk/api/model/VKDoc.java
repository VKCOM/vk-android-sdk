package com.vk.sdk.api.model;

/**
 * Document
 * Created by alex_xpert on 29.01.14.
 */
public class VKDoc extends VKApiModel {
    public long id; // идентификатор документа
    public long owner_id; // идентификатор пользователя, загрузившего документ
    public String title; // название документа
    public long size; // размер документа в байтах
    public String ext; // расширение документа
    public String url; // адрес документа, по которому его можно загрузить
    public String photo_100; // адрес изображения с размером 100x75px (если файл графический)
    public String photo_130; // адрес изображения с размером 130x100px (если файл графический)
}
