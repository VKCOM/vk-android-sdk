package com.vk.sdk.api.model;

import java.util.Map;

/**
 * Comment
 * Created by alex_xpert on 29.01.14.
 */
public class VKComment extends VKApiModel {
    public long id; // идентификатор комментария
    public long from_id; // идентификатор автора комментария
    public long date; // дата создания комментария в формате unixtime
    public String text; // текст комментария
    public long reply_to_user; // идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо)
    public long reply_to_comment; // идентификатор комментария, в ответ на который оставлен текущий (если применимо)
    public Map<String, Object> attachments; // объект, содержащий информацию о медиавложениях в комментарии

    public Map<String, Integer> likes; // for method wall.getComments
}
