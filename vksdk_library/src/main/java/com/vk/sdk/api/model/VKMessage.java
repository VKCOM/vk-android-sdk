package com.vk.sdk.api.model;

import java.util.Map;

/**
 * Message
 * Created by alex_xpert on 29.01.14.
 */
public class VKMessage extends VKApiModel {
    public long id; // идентификатор сообщения (не возвращается для пересланных сообщений)
    public long user_id; // идентификатор автора сообщения (для исходящего сообщения — идентификатор получателя)
    public long date; // дата отправки сообщения в формате unixtime
    public boolean read_state; // статус сообщения (0 — не прочитано, 1 — прочитано, не возвращается для пересланных сообщений)
    public boolean out; // тип сообщения (0 — полученное, 1 — отправленное, не возвращается для пересланных сообщений)
    public String title; // заголовок сообщения или беседы
    public String body; // текст сообщения
    public Map<String, Object> geo; // информация о местоположении
    public Map<String, Object> attachments; // массив медиа-вложений
    public VKMessageArray fwd_messages; // массив пересланных сообщений (если есть)
    public boolean emoji; // содержатся ли в сообщении emoji-смайлы
    public boolean important; // является ли сообщение важным
    public boolean deleted; // удалено ли сообщение

    public long chat_id; // идентификатор беседы
    public String chat_active; // идентификаторы участников беседы
    public int users_count; // количество участников беседы
    public long admin_id; // идентификатор создателя беседы
    public String photo_50; // url копии фотографии беседы шириной 50px
    public String photo_100; // url копии фотографии беседы шириной 100px
    public String photo_200; // url копии фотографии беседы шириной 200px
}
