package com.vk.sdk.api.model;

/**
 * Audio
 * Created by alex_xpert on 28.01.14.
 */
public class VKAudio extends VKApiModel {
    public long id; // идентификатор аудиозаписи
    public long owner_id; // идентификатор владельца аудиозаписи
    public String artist; // исполнитель
    public String title; // название композиции
    public int duration; // длительность аудиозаписи в секундах
    public String url; // ссылка на mp3
    public long lyrics_id; // идентификатор текста аудиозаписи (если доступно)
    public long album_id; // идентификатор альбома, в котором находится аудиозапись (если присвоен)
    public int genre_id; // идентификатор жанра из списка аудио жанров
}
