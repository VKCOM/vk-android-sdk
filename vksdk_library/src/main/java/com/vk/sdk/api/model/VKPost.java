package com.vk.sdk.api.model;

import java.util.Map;

/**
 * Post
 * Created by alex_xpert on 29.01.14.
 */
public class VKPost extends VKApiModel {
    public long id; // идентификатор записи
    public long owner_id; // идентификатор владельца стены, на которой размещена запись (API 5.7)
    public long to_id; // идентификатор владельца стены, на которой размещена запись (API < 5.7)
    public long from_id; // идентификатор автора записи
    public long date; // время публикации записи в формате unixtime
    public String text; // текст записи
    public long reply_owner_id; // идентификатор владельца записи, в ответ на которую была оставлена текущая
    public long reply_post_id; // идентификатор записи, в ответ на которую была оставлена текущая
    public boolean friends_only; // true, если запись была создана с опцией «Только для друзей»
    public Map<String, Object> comments; // информация о комментариях к записи
    public Map<String, Object> likes; // информация о лайках к записи
    public Map<String, Object> reposts; // информация о репостах записи («Рассказать друзьям»)
    public String post_type; // тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest
    public Map<String, String> post_source; // информация о способе размещения записи
    public Map<String, Object> attachments; // информация о вложениях записи (фотографии, ссылки и т.п.)
    public Map<String, Object> geo; // информация о местоположении
    public long signer_id; // идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    public VKPostArray copy_history; // массив, содержащий историю репостов для записи. Возвращается только в том случае, если запись является репостом.
}
