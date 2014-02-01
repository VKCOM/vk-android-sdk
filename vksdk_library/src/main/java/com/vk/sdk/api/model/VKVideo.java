package com.vk.sdk.api.model;

/**
 * Video
 * Created by alex_xpert on 29.01.14.
 */
public class VKVideo extends VKApiModel {
    public long id; // идентификатор видеозаписи
    public long owner_id; // идентификатор владельца видеозаписи
    public String title; // название видеозаписи
    public String description; // текст описания видеозаписи
    public int duration; // длительность ролика в секундах
    public String link; // строка, состоящая из ключа video+vid
    public String photo_130; // url изображения-обложки ролика с размером 130x98px
    public String photo_320; // url изображения-обложки ролика с размером 320x240px
    public String photo_640; // url изображения-обложки ролика с размером 640x480px (если размер есть)
    public long date; // дата добавления видеозаписи в формате unixtime
    public int views; // количество просмотров видеозаписи
    public int comments; // количество комментариев к видеозаписи
    public String player; // адрес страницы с плеером, который можно использовать для воспроизведения ролика в браузере. Поддерживается flash и html5, плеер всегда масштабируется по размеру окна
}
