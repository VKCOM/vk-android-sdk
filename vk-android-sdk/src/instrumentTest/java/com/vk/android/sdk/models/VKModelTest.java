/**
 * VKChatTest.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 02.02.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import android.test.AndroidTestCase;
import org.json.JSONObject;

public class VKModelTest extends AndroidTestCase {

    final static String COMMENTS_TEST = "{\"response\":{\"count\":16,\"items\":[{\"id\":3200,\"from_id\":3197366,\"date\":1375979966,\"text\":\"Однако баг:\",\"likes\":{\"count\":1,\"user_likes\":0,\"can_like\":1},\"attachments\":[{\"type\":\"photo\",\"photo\":{\"id\":308701914,\"album_id\":-5,\"owner_id\":3197366,\"photo_75\":\"http:\\/\\/cs6035.vk.me\\/v6035288\\/6ef0\\/q4rguINFKc0.jpg\",\"photo_130\":\"http:\\/\\/cs6035.vk.me\\/v6035288\\/6ef1\\/sjEQyroiYac.jpg\",\"photo_604\":\"http:\\/\\/cs6035.vk.me\\/v6035288\\/6ef2\\/24e6zf6JT8E.jpg\",\"width\":591,\"height\":118,\"text\":\"Original: http:\\/\\/s2.1pic.org\\/files\\/2013\\/08\\/08\\/e89e7b5e6b7cfe6d8aa5.jpg\",\"date\":1375979968,\"access_key\":\"bfb4d688475710f4d6\"}}]},{\"id\":3201,\"from_id\":3197366,\"date\":1375979984,\"text\":\"И, я думаю, если я не админ, то мне не нужны фотографии сообщества, не?\",\"likes\":{\"count\":0,\"user_likes\":0,\"can_like\":1}},{\"id\":3202,\"from_id\":40001922,\"date\":1375980076,\"text\":\"Наконец-то! Спасибо.\",\"likes\":{\"count\":0,\"user_likes\":0,\"can_like\":1}},{\"id\":3203,\"from_id\":19498153,\"date\":1375980513,\"text\":\"Лимит увеличь, молю!\",\"likes\":{\"count\":2,\"user_likes\":0,\"can_like\":1}},{\"id\":3204,\"from_id\":85635407,\"date\":1375980529,\"text\":\"[id19498153|Макс], не могу =(\",\"likes\":{\"count\":0,\"user_likes\":0,\"can_like\":1},\"reply_to_user\":19498153,\"reply_to_comment\":3203},{\"id\":3205,\"from_id\":85635407,\"date\":1375980597,\"text\":\"[id3197366|Андрей], поправил\",\"likes\":{\"count\":0,\"user_likes\":0,\"can_like\":1},\"reply_to_user\":3197366,\"reply_to_comment\":3200},{\"id\":3208,\"from_id\":4347183,\"date\":1375999184,\"text\":\"Чёрт возьми, это круто.\",\"likes\":{\"count\":0,\"user_likes\":0,\"can_like\":1}},{\"id\":3210,\"from_id\":111862816,\"date\":1376067558,\"text\":\"Очень полезная функция))\\nТолько не всегда находит именно то,что надо\",\"likes\":{\"count\":0,\"user_likes\":0,\"can_like\":1}},{\"id\":3211,\"from_id\":132570235,\"date\":1376070925,\"text\":\"(когда Enter нажимаешь после ввода)\",\"likes\":{\"count\":2,\"user_likes\":0,\"can_like\":1},\"attachments\":[{\"type\":\"photo\",\"photo\":{\"id\":308061694,\"album_id\":-5,\"owner_id\":132570235,\"photo_75\":\"http:\\/\\/cs421422.vk.me\\/v421422235\\/72b5\\/LChP-32Bf5w.jpg\",\"photo_130\":\"http:\\/\\/cs421422.vk.me\\/v421422235\\/72b6\\/ApTCX2bde74.jpg\",\"photo_604\":\"http:\\/\\/cs421422.vk.me\\/v421422235\\/72b7\\/IBJOmYb0aWI.jpg\",\"photo_807\":\"http:\\/\\/cs421422.vk.me\\/v421422235\\/72b8\\/7AhQHZ4y0DQ.jpg\",\"width\":694,\"height\":201,\"text\":\"\",\"date\":1376070921,\"access_key\":\"24820a8b71591b01ad\"}}]},{\"id\":3212,\"from_id\":121863726,\"date\":1376073204,\"text\":\"Почему бы не сделать надпись поменьше?\",\"likes\":{\"count\":0,\"user_likes\":0,\"can_like\":1}}]}}";
    final static String POST_TEST = "{\"response\":{\"count\":149,\"items\":[{\"id\":45615,\"from_id\":1,\"owner_id\":1,\"date\":1391281072,\"post_type\":\"post\",\"text\":\"С сегодняшнего дня в российском интернете начинается новая эпоха. Вступает в силу закон, согласно которому любой интернет-ресурс может быть заблокирован без решения суда — например, за призывы участвовать в митингах.\",\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":49992,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":10636,\"user_reposted\":0}},{\"id\":45614,\"from_id\":1,\"owner_id\":1,\"date\":1390587609,\"post_type\":\"post\",\"text\":\"То, чем Вы владеете, рано или поздно начинает владеть Вами.\\n\\nПоследние несколько лет я активно избавлялся от собственности, отдавая и продавая все, что у меня было, — от мебели и вещей до недвижимости и компаний. Для достижения идеала мне оставалось избавиться от самой крупной части своего имущества — 12%-й доли ВКонтакте. Я рад, что не так давно я достиг и этой цели, продав свою долю ВКонтакте моему другу Ивану Таврину. \\n\\nЭто изменение едва ли отразится на управлении ВКонтакте — совет директоров прислушивается к моему мнению не из-за наличия или отсутствия у меня доли, а потому, что я создал эту сеть и понимаю ее глубинные механизмы. Я никуда не ухожу и собираюсь продолжать следить за качеством ВКонтакте. В конце концов, ВКонтакте — лучшее, что было создано в России в коммуникационной сфере. И моя ответственность состоит в том, чтобы беречь и защищать эту сеть.\",\"attachments\":[{\"type\":\"photo\",\"photo\":{\"id\":285102078,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs9579.vk.me\\/v9579001\\/15f0\\/NpEhbGzSnfU.jpg\",\"photo_130\":\"http:\\/\\/cs9579.vk.me\\/v9579001\\/15f1\\/zpEHzlJaNOA.jpg\",\"photo_604\":\"http:\\/\\/cs9579.vk.me\\/v9579001\\/15f2\\/Fv-azAraPJM.jpg\",\"width\":444,\"height\":413,\"text\":\"\",\"date\":1338854651,\"access_key\":\"088f162cbd7f3320e3\"}}],\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":198731,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":25811,\"user_reposted\":0}},{\"id\":45613,\"from_id\":1,\"owner_id\":1,\"date\":1390433390,\"post_type\":\"post\",\"text\":\"Тот, кто ничего не боится, более могуществен, чем тот, кого боятся все.\\n\\nКодекс чести русского офицера, 1904 год.\",\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":77287,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":7712,\"user_reposted\":0}},{\"id\":45611,\"from_id\":1,\"owner_id\":1,\"date\":1390260904,\"post_type\":\"post\",\"text\":\"ВКонтакте взял новую высоту — 60 миллионов человек за сутки.\",\"attachments\":[{\"type\":\"photo\",\"photo\":{\"id\":320624027,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/945b\\/6JwHSc5wLGg.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/945c\\/xxlEPKAyYXM.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/945d\\/jvCKTR8CAHg.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/945e\\/UUCwCY799wQ.jpg\",\"width\":609,\"height\":556,\"text\":\"\",\"date\":1390260965,\"access_key\":\"cc0f141786ad34b22b\"}}],\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":68827,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":3634,\"user_reposted\":0}},{\"id\":45610,\"from_id\":1,\"owner_id\":1,\"date\":1390061803,\"post_type\":\"post\",\"text\":\"Бюрократическая структура, которая призвана с чем-то бороться, едва ли станет устранять корень проблемы. Более вероятно, что она будет незаметно стимулировать то, что должна уничтожить. Только так она сможет расширять свое влияние и финансирование.\",\"post_source\":{\"platform\":\"iphone\",\"type\":\"api\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":26174,\"user_likes\":1,\"can_like\":0,\"can_publish\":1},\"reposts\":{\"count\":2130,\"user_reposted\":0}},{\"id\":45609,\"from_id\":1,\"owner_id\":1,\"date\":1389855901,\"post_type\":\"post\",\"text\":\"\",\"copy_history\":[{\"id\":36791,\"owner_id\":6,\"from_id\":6,\"date\":1389824602,\"post_type\":\"post\",\"text\":\"Спрашивают, что я думаю о чудесах. Хорошо, давайте обсудим чудеса.\\n\\nПрежде всего, надо понять, что это такое. Есть несколько вариантов:\\n\\n1) События, противоречащие законам природы.\\n\\nНапример, если фокусник материализовал кролика в ранее пустой шляпе, он нарушил фундаментальный закон физики — закон сохранения энергии-массы.\\n\\nМожно нарушать не только физические законы, но и химические или биологические.\\n\\nНапример, если девственница родила мальчика, то непонятно, откуда у этого мальчика взялась Y-хромосома. Такое событие кардинально нарушает законы биологии и потому является чудом.\\n\\nДля простоты предлагаю считать, что нарушить законы природы нельзя. Если кто-либо утверждает, что он это сделал, необходимо предъявить доказательства, исключающие всевозможные альтернативные объяснения (фокусник отвлёк наше внимание и переместил кролика в шляпу из другого места, \\\"девственница\\\" вступала в половую связь с римским центурионом, но постеснялась признаться и т.п.), поскольку они априори более вероятны, а также придумать объяснения, в которые бы, помимо предлагаемого чуда, вписывались все предыдущие наблюдения и новые факты.\\n\\nТут есть небольшая тонкость. Мы, очевидно, ещё не знаем всех законов природы, а те, что знаем, наверняка будут уточняться в будущем. Однако их уточнения должны давать те же результаты, что и нынешние теории в общих рамках их применимости и в пределах погрешностей нынешних измерений. Для описания событий в \\\"бытовых\\\" масштабах накопленных человечеством знаний обычно более чем достаточно.\\n\\nНапример, можно попытаться сказать, что народный целитель ощущает \\\"биополе\\\" (или \\\"ауру\\\") пациента и пытается его \\\"исправить\\\", делая те или иные пассы. Однако физике известно только четыре (хорошо, пять) фундаментальных взаимодействий, и если бы существовали какие-либо ещё, способные воздействовать на крупные предметы вроде человеческих тел, сверхточные физические приборы давно бы зафиксировали их проявления. Поэтому любые \\\"биополя\\\" должны объясняться комбинацией существующих полей. Говорят, на самом деле целители ощущают руками градиент тепла (или инфракрасного излучения), исходящего от тела пациента, и находят те точки, где тепла чуть больше или чуть меньше — это узлы, в которых проблема. Не знаю, так это или нет, но в любом случае ничего сверхестественного здесь нет.\\n\\n2) Априори возможные, но маловероятные события.\\n\\nНапример, априорная вероятность того, что президент хоть какой-нибудь страны выиграет главный приз в общенациональной лотерее порядка одной миллионной. Однако в Зимбабве такое чудо случилось.\\n\\nИли, например, если я играю в напёрстки 100 раз подряд, указываю на случайно выбранный стаканчик и каждый раз не угадываю, где шарик, то происходит событие с априорной вероятностью (2\\/3)^100 — примерно 2*10^{-18}. По идее, такого не должно случиться ни разу, даже если каждый житель Земли будет повторять этот опыть раз в день.\\n\\nКроме того, очень мала вероятность того, что в каком-нибудь регионе абсолютно все жители проголосуют за действующую власть. Такое тоже случается.\\n\\nНесложно видеть, что в данных примерах неправильно вычислялась (занижалась) априорная вероятность события, потому что не учитывалась часть существенных факторов.\\n\\nДругой пример — все молекулы в этой комнате соберутся в той её половине, где нет меня, и я задохнусь. Вероятность подобного рода событий, напротив, настолько мала (порядка 10^{-10^{23}}), что оно не случится ни разу за всё существование Вселенной. Таким образом, нарушение второго закона термодинамики формально является чудом второго рода, но на самом деле правильнее считать его чудом первого рода (нарушением фундаментального закона физики).\\n\\nСюда же относится, например, спонтанное восстановление разбитой чашки из осколков, а также воскрешение из мёртвых (смерть — это по определению \\\"необратимое прекращение жизненных функций\\\").\\n\\n3) События, не нарушающие законов природы и не являющиеся маловероятными, но ошибочно воспринимаемые как таковые.\\n\\nНапример, маленькие дети не понимают, как именно фокусник вытаскивает кролика из шляпы или почему распиленная им ассистентка оказывается живой, и считают, что произошло нечто чудесное, а на самом деле произошёл фокус.\\n\\nК сожалению, в ситуациях, когда нам заранее не сообщают, что производится фокус, даже взрослый человек (и даже профессиональный учёный) может не понять, что происходит, и решить, что случилось \\\"чудо\\\" или зафиксировать случай телепатии и прочих экстрасенсорных способностей. Когда фокусами начинают пользоваться для мошенничества, простым людям сложно поймать мошенника за руку, и если они доверчивы — приходится признать, что имело место чудо. Кстати, когда в 19-м веке была мода на медиумов, довольно известные учёные не могли понять, в чём дело, и признавали существование духов, экстрасенсорных способностей и т.п. Потом к разоблачению медиумов стали привлекать специалистов — то есть фокусников — и ситуация исправилась. (На эту тему есть интересная книжка Хэнзела, переведённая на русский язык.)\\n\\nДругие примеры таких чудес. Известный иллюзионист Ури Геллер призывает телезрителей принести к экрану поломавшиеся часы, чтобы он мог своими пассами их дистанционно починить, а затем просит позвонить тех, у кого получилось. Оказывается, что если просто встряхнуть старые поломавшиеся часы, то с небольшой вероятностью вроде одной десятитысячной они могут пойти (например, если дело в пылинке, попавшей не туда). Если передачу смотрит миллион зрителей, и десятая часть из них действительно принесёт к экрану старые часы, Ури Геллер получит десятки телефонных звонков от изумлённых телезрителей.\\n\\nКак видим, вероятность на самом деле не очень мала (1000000 * 0.1 * 0.0001 = 10 успешных случаев), но изначально воспринимается как очень маленькая.\\n\\nКстати, это свойство человеческого мозга — он плохо работает с очень маленькими (и очень большими) числами. Интуитивно всё, что меньше одной сотой — это \\\"очень мало\\\". На самом деле между вероятностями в одну миллионную и 10^{-10^{23}} очень большая разница. События вероятностью одная миллионная происходят сплошь и рядом, если наблюдений много (например, если их производят все жители Земли). События вероятностью 10^{-10^{23}} не случатся ни разу за всё существование Вселенной.\\n\\nИли такой пример — жрецы разводят огонь на жертвеннике храма и возносят молитвы к своим богам, а ворота храма чудесным образом сами открываются. Доверчивые зрители говорят о чуде и начинают жертвовать жрецам. Такой вот пневматический механизм придумал Герон Александрийский пару тысяч лет назад.\\n\\nДумаете, сейчас такое не прокатит? Как насчёт современного примера — в храме заблаговременно пропитывают фитили свеч соединениями фосфора, но свечи не зажигают. Затем в храм пускают публику и заслуженного жреца (демонстрируя, что у него нет спичек), и он начинает молиться. Через какое-то время свечи спонтанно зажигаются, а доверчивым зрителям объясняют, что это чудо, произведённое божеством в ответ на действия жреца. \\n\\nДо сих пор находятся люди, верящие в подобное.\\n\\n4) Нечто, субъективно и эмоционально воспринимаемое как чудесное, хотя и не являющееся необычным.\\n\\nСкажем, радуга или красивый закат могут произвести впечатление чуда и вызвать эмоциональный подъём. Аналогично с красивым стихотворением или неожиданным научным озарением.\\n\\nТакого рода чудеса нравятся и мне.\\n\\n5) Почему людям хочется верить в чудеса?\\n\\nПо всей видимости, люди легко обманываются разнообразными фокусниками, жрецами и прочими мошенниками, или даже самими собой (вопреки здравому смыслу объясняя чудесами то, что на самом деле являтся природным явлением или случайным совпадением) потому, что им хочется обманываться. Почему-то чудесные объяснения нам более импонируют, чем правильные, но \\\"скучные\\\" рациональные объяснения. Конечно, на людей с научно-технической складом ума именно эти рациональные объяснения могут произвести впечатление большего чуда в смысле 4) (например, объяснение разнообразия земной биосферы через теорию эволюции, на мой взгляд, гораздо интереснее, чем через акт произвольного творения высшими силами), но не будем отвлекаться. Как мы видели, даже серьёзные учёные иногда бывают сбиты с толку и готовы поверить в \\\"экстрасенсорные\\\" способности и прочих медиумов и провидцев.\\n\\nИнтересно понять, откуда у людей эта склонность верить в чудеса и объяснять всё чудесами вместо того, чтобы искать рациональное объяснение. Должно быть биологическое, социальное и психологическое обоснование этого явления. Вот некоторые соображения на эту тему.\\n\\nа) Объяснение через чудеса явлений, не являющихся жизненно важными, экономит умственные усилия, меньше напрягает мозг, а значит, требует меньше глюкозы и меньше еды — иначе говоря, буквально является более экономным и более выгодным. На протяжении миллионов лет эволюции предков человека это могло быть полезным — если знание о том, что Солнце — это огромный шар, вокруг которого вращается меньший шар-Земля, не приносит практической пользы, то не лучше ли не тратить ресурсы на обдумывание подобных истин, а вместо этого объяснить восходы и заходы мифологическими и чудесными причинами?\\n\\nб) Дети в маленьком возрасте сильно зависят от взрослых и от того, чему их взрослые научат. При этом фундаментальным является некритическое восприятие того, что говорят взрослые. Сюда относятся упрощённые описания бытовых явлений через чудеса, сказки и мифологию, способствующие, однако, правильному поведению детей (увеличивающие их шансы на выживание). Привыкнув к чудесам в детстве, сложно полностью отказаться от них потом, особенно если это не считается зазорным в обществе. Кстати, обычно годам к десяти все перестают верить в Деда Мороза (потому что сверстники будут смотреть на того, кто не перестанет, как на идиота), а вот в различного рода богов и пророков (а также в демократию) некоторые люди продолжают верить даже во взрослом возрасте (потому что не создаётся подобного давления в обществе — оно скорее может быть создано в обратную сторону).\\n\\nв) Социальное давление. Если все вокруг во что-то верят, гораздо проще поверить в это или сначала просто сделать вид, что поверил — а потом незамысловатые психологические механизмы сделают так, что человек действительно поверит. Таким образом, например, несколько человек в компании, сговорившись, могут заставить оставшегося поверить, что нечто было (например, что они все вместе видели ранее умершего наставника), имплантировав в его сознание сначала сомнения, а потом уверенность в нужной им версии событий. Если же уверенность транслируется не просто несколькими людьми, а всем обществом (или тоталитарной сектой, в которую вы попали), то устоять против веры в чудеса и общепринятые чудесные объяснения будет очень сложно.\\n\\nг) Человеческий мозг — это машина для поиска шаблонов и корреляций между поступающими данными. Таково его устройство, и в этом его сила и его слабость. Понятие причинно-следственной связи не \\\"зашито\\\" в наш мозг, а вырабатывается в процессе обучения, равно как, например, умение складывать числа. А вот корреляции мы фиксируем автоматически и затем начинаем их использовать. Если после того, как нам перешла дорогу чёрная кошка, мы не сдаём экзамен, у нас фиксируется корреляция, при этом мы обычно не пытаемся произвести затратный высокоуровневый анализ причинно-следственных связей. Затем, если после очередной чёрной кошки произойдёт что-нибудь плохое, мы скажем: \\\"ага, примета работает\\\", несмотря на то, что было много случаев, когда чёрная кошка переходила нам дорогу, но ничего плохого не случалось и мы об этом благополучно забывали.\\n\\nИначе говоря, сам принцип устройства мозга способствует выделению шаблонов из случайного шума. Мы можем вполне увидеть контуры непонятного зверя в тёмном саду просто потому, что луна осветила дерево с необычного угла. Может быть, это не так плохо с эволюционной точки зрения — а вдруг там действительно притаился леопард, и надо действовать, а не раздумывать, померещилось это или нет. Однако в итоге появляются рассказы о леших и прочих чудесах. \\n\\n* * *\\n\\nКак-то так. Извините, если вы верили в чудеса, приметы, экстрасенсов и прочую магию, а я вас разочаровал — но я действительно считаю, что чудеса науки и техники, а также искусства, гораздо интереснее всех этих древних заблуждений, ошибок человеческого восприятия, фокусов и мошенничества. Подумайте, какова бы была реакция древнего человека, если бы вы ему показали свой айфон — а ведь для нас это нечто обыденное. И это только начало.\\n\\nЧудесам есть место в нашей жизни. Однако нужно искать их там, где они действительно есть, а не заниматься самообманом.\",\"post_source\":{\"type\":\"vk\"}}],\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":18629,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":3588,\"user_reposted\":0}},{\"id\":45608,\"from_id\":1,\"owner_id\":1,\"date\":1388429132,\"post_type\":\"post\",\"text\":\"Всем, кто стремится к саморазвитию.\",\"attachments\":[{\"type\":\"photo\",\"photo\":{\"id\":318855985,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84cd\\/9xJu7SC6a0k.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84ce\\/rrd-9Fivkw4.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84cf\\/CD0VTEpr9pg.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84d0\\/dA7cOgeAO4k.jpg\",\"width\":609,\"height\":588,\"text\":\"\",\"date\":1388428614,\"access_key\":\"5df1165e15ab50d3ec\"}},{\"type\":\"photo\",\"photo\":{\"id\":318855987,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84d5\\/YT1BgY1Fy48.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84d6\\/D51m-Y30lFo.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84d7\\/Tvh36iwZu0o.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84d8\\/_W6vdc1q8BE.jpg\",\"width\":609,\"height\":588,\"text\":\"\",\"date\":1388428615,\"access_key\":\"89ce3d34a87ae9830b\"}},{\"type\":\"photo\",\"photo\":{\"id\":318855990,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84dd\\/LbB73qHBtdk.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84de\\/HvKemBJVw9Y.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84df\\/j8-LcP9nmE0.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84e0\\/nCQ6xaq1c4c.jpg\",\"width\":609,\"height\":588,\"text\":\"\",\"date\":1388428616,\"access_key\":\"23e413d90f017442bd\"}},{\"type\":\"photo\",\"photo\":{\"id\":318855992,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84e5\\/NbK3meKigWI.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84e6\\/lLomrSD-BZo.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84e7\\/JGcqJsB13j0.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84e8\\/Ml7PZuyYTZY.jpg\",\"width\":609,\"height\":588,\"text\":\"\",\"date\":1388428616,\"access_key\":\"8425fba835f02cad2a\"}},{\"type\":\"photo\",\"photo\":{\"id\":318855995,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84ed\\/BVaHg1a3svw.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84ee\\/1DvMhaELGvE.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84ef\\/ZeFTaI7cS70.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84f0\\/HcYeBuaYUMg.jpg\",\"width\":609,\"height\":588,\"text\":\"\",\"date\":1388428617,\"access_key\":\"0e77a192fa8d8b7c88\"}},{\"type\":\"photo\",\"photo\":{\"id\":318855999,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84f5\\/yt3kcdGBAdI.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84f6\\/W5V1Iem_zSs.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84f7\\/atwNkCmAJfo.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/84f8\\/XdTn7H7ACeA.jpg\",\"width\":609,\"height\":588,\"text\":\"\",\"date\":1388428618,\"access_key\":\"5044f30172f0219b13\"}},{\"type\":\"photo\",\"photo\":{\"id\":318869260,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8512\\/Lz9Om2nH7ws.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8513\\/eTw2eVnJGZY.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8514\\/xOgTUSphy0g.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8515\\/AqjVSivDR7U.jpg\",\"width\":609,\"height\":670,\"text\":\"\",\"date\":1388437503,\"access_key\":\"965be6bd333ab03ec5\"}}],\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":206853,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":45320,\"user_reposted\":0}},{\"id\":45607,\"from_id\":1,\"owner_id\":1,\"date\":1388424496,\"post_type\":\"post\",\"text\":\"В 2013 году ВКонтакте увеличил аудиторию своих мобильных приложений в 5 раз и закрепился на первом месте по скачиваниям на Android, iPhone, iPad и Windows Phone. Это произошло благодаря запуску в уходящем году полностью новых приложений ВКонтакте под все эти платформы.\\n\\n#Итоги2013@durov\",\"attachments\":[{\"type\":\"photo\",\"photo\":{\"id\":318847609,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/843f\\/bYPQWHQmJT4.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8440\\/raTzgdXDsfk.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8441\\/912Jrun_9bg.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8442\\/XKOZth7c1p0.jpg\",\"photo_1280\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8443\\/nm_VFWqU4Zw.jpg\",\"width\":1024,\"height\":768,\"text\":\"\",\"date\":1388423467,\"access_key\":\"51355efa2adfd6a609\"}},{\"type\":\"photo\",\"photo\":{\"id\":318848933,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8475\\/ertF6cB5PDs.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8476\\/WDQoC4ZaLBs.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8477\\/Zv2VQI9jBag.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8478\\/oLX8w_koV8c.jpg\",\"photo_1280\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8479\\/6tp_s4L_Z90.jpg\",\"width\":1024,\"height\":768,\"text\":\"\",\"date\":1388424299,\"access_key\":\"db2f44d1485e9657f4\"}},{\"type\":\"photo\",\"photo\":{\"id\":318848982,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8487\\/XYcD5zo7Guo.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8488\\/re0JzybAPu8.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8489\\/oq4DriB6gZc.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/848a\\/dnG7u3sKiZI.jpg\",\"photo_1280\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/848b\\/D316kd2ifZw.jpg\",\"width\":1024,\"height\":768,\"text\":\"\",\"date\":1388424333,\"access_key\":\"f2556a89218a17440f\"}},{\"type\":\"photo\",\"photo\":{\"id\":318848944,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/847e\\/cW_7GqQdS4M.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/847f\\/KqatG9SeraI.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8480\\/18hdSovIKqg.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8481\\/wDDCtGL1qUE.jpg\",\"photo_1280\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8482\\/QokvzhIFhng.jpg\",\"width\":1024,\"height\":768,\"text\":\"\",\"date\":1388424308,\"access_key\":\"0f231c7c37574d2523\"}},{\"type\":\"photo\",\"photo\":{\"id\":318848913,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/846c\\/MelWvMlcFqU.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/846d\\/yt-bewkYRiU.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/846e\\/VkF_WrGY03U.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/846f\\/sWSnv3nEztc.jpg\",\"photo_1280\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/8470\\/XVl1egdGGZM.jpg\",\"width\":1024,\"height\":768,\"text\":\"\",\"date\":1388424287,\"access_key\":\"95c81e6ba21cc59b87\"}}],\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":19604,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":923,\"user_reposted\":0}},{\"id\":45606,\"from_id\":1,\"owner_id\":1,\"date\":1388313900,\"post_type\":\"post\",\"text\":\"В 2013 году увеличилось количество людей, которые пользуются только ВКонтакте и не заходят в другие социальные сети. В то же время количество людей, которые пользуются другими сетями и не заходят в VK, существенно сократилось. Скоро их не останется.\\n\\n#Итоги2013@durov\",\"attachments\":[{\"type\":\"photo\",\"photo\":{\"id\":318733624,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83b0\\/d4n0MRpjjOQ.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83b1\\/Y4sfHlctS0Y.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83b2\\/MMS9cLKzg9w.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83b3\\/ftfdSAs2nmk.jpg\",\"photo_1280\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83b4\\/mDLsTlzNI5U.jpg\",\"width\":1024,\"height\":768,\"text\":\"\",\"date\":1388313870,\"post_id\":45606,\"access_key\":\"5efc158cbcf97db2b1\"}}],\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":32329,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":2491,\"user_reposted\":0}},{\"id\":45605,\"from_id\":1,\"owner_id\":1,\"date\":1388313672,\"post_type\":\"post\",\"text\":\"В 2013 году ВКонтакте был полностью переписан на разработанный нами компилируемый язык программирования. Результат — удвоение скорости работы всех сервисов и еще более стремительный отрыв от конкурентов.\\n\\n#Итоги2013@durov\",\"attachments\":[{\"type\":\"photo\",\"photo\":{\"id\":318733062,\"album_id\":-7,\"owner_id\":1,\"photo_75\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83a7\\/_1cWoUqLZoY.jpg\",\"photo_130\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83a8\\/fMqtpo5k-Ko.jpg\",\"photo_604\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83a9\\/GsbM3UP4Rk0.jpg\",\"photo_807\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83aa\\/dYdSLN5XEWU.jpg\",\"photo_1280\":\"http:\\/\\/cs14101.vk.me\\/c540101\\/v540101001\\/83ab\\/t5B4tnNxX1I.jpg\",\"width\":1024,\"height\":768,\"text\":\"\",\"date\":1388313442,\"post_id\":45605,\"access_key\":\"c8c874541e18722d08\"}}],\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":0,\"can_post\":0},\"likes\":{\"count\":27724,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":1222,\"user_reposted\":0}}]}}";

    public void testComments() throws Exception {
       VKList<VKComment> comments = new VKList<VKComment>(ParseUtils.rootJSONObject(COMMENTS_TEST), VKComment.class);
       assertTrue(comments.size() == 10);
    }

    public void testPosts() throws Exception {
        VKList<VKPost> comments = new VKList<VKPost>(ParseUtils.rootJSONObject(POST_TEST), VKPost.class);
        assertTrue(comments.size() == 10);
    }

    public void testReflectionParser() throws Exception {
        Reflector r = new Reflector();
        r.parse(new JSONObject(Reflector.STR));
        assertNotNull(r.cls);
        assertNotNull(r.subclass);
    }

    public static class Reflector extends VKModel {

        public final static String STR = "{\n" +
                "    \"d\": 0.00561,\n" +
                "    \"i\": 34,\n" +
                "    \"b\": 1,\n" +
                "    \"s\": \"String\",\n" +
                "    \"cls\": {\n" +
                "        arr: [1, 2, 3]\n" +
                "    },\n" +
                "    \"subclass\": [\n" +
                "        {\n" +
                "            arr: [1, 2, 3]\n" +
                "        },{\n" +
                "            arr: [4, 5, 6]\n" +
                "        },{\n" +
                "            arr: [7, 8, 9]\n" +
                "        }\n" +
                "    ],\n" +
                "        sizes: [{\n" +
                "        src: 'http://cs14101.vk.me/c540101/v540101001/945b/6JwHSc5wLGg.jpg',\n" +
                "        width: 75,\n" +
                "        height: 69,\n" +
                "        type: 's'\n" +
                "        }, {\n" +
                "        src: 'http://cs14101.vk.me/c540101/v540101001/945c/xxlEPKAyYXM.jpg',\n" +
                "        width: 130,\n" +
                "        height: 119,\n" +
                "        type: 'm'\n" +
                "        }, {\n" +
                "        src: 'http://cs14101.vk.me/c540101/v540101001/945d/jvCKTR8CAHg.jpg',\n" +
                "        width: 604,\n" +
                "        height: 551,\n" +
                "        type: 'x'\n" +
                "        }, {\n" +
                "        src: 'http://cs14101.vk.me/c540101/v540101001/945e/UUCwCY799wQ.jpg',\n" +
                "        width: 609,\n" +
                "        height: 556,\n" +
                "        type: 'y'\n" +
                "        }, {\n" +
                "        src: 'http://cs14101.vk.me/c540101/v540101001/945f/zszwtSYuhmI.jpg',\n" +
                "        width: 130,\n" +
                "        height: 119,\n" +
                "        type: 'o'\n" +
                "        }, {\n" +
                "        src: 'http://cs14101.vk.me/c540101/v540101001/9460/ZJHE7FzVAp4.jpg',\n" +
                "        width: 200,\n" +
                "        height: 183,\n" +
                "        type: 'p'\n" +
                "        }, {\n" +
                "        src: 'http://cs14101.vk.me/c540101/v540101001/9461/dlrGhJysyLk.jpg',\n" +
                "        width: 320,\n" +
                "        height: 292,\n" +
                "        type: 'q'\n" +
                "        }, {\n" +
                "        src: 'http://cs14101.vk.me/c540101/v540101001/9462/JlEcsJk_eQA.jpg',\n" +
                "        width: 510,\n" +
                "        height: 466,\n" +
                "        type: 'r'\n" +
                "        }],\n" +
                "        attachments: [{\n" +
                "        type: 'photo',\n" +
                "        photo: {\n" +
                "        id: 308701914,\n" +
                "        album_id: -5,\n" +
                "        owner_id: 3197366,\n" +
                "        photo_75: 'http://cs6035.vk.me/v6035288/6ef0/q4rguINFKc0.jpg',\n" +
                "        photo_130: 'http://cs6035.vk.me/v6035288/6ef1/sjEQyroiYac.jpg',\n" +
                "        photo_604: 'http://cs6035.vk.me/v6035288/6ef2/24e6zf6JT8E.jpg',\n" +
                "        width: 591,\n" +
                "        height: 118,\n" +
                "        text: 'Original: http://s2.1pic.org/files/2013/08/08/e89e7b5e6b7cfe6d8aa5.jpg',\n" +
                "        date: 1375979968,\n" +
                "        access_key: 'bfb4d688475710f4d6'\n" +
                "        }\n" +
                "        }],\n" +
                "        \"list\": [ {\"id\":1}, {\"id\": 2}\n" +
                "        ]\n" +
                "}";


        public double d;
        public int i;
        public boolean b;
        public String s;
        public Subclass[] subclass;
        public Subclass cls;
        public VKPhotoSizes sizes = new VKPhotoSizes();
        public VKAttachments attachments = new VKAttachments();
        public VKList<Item> list = new VKList<Item>();


        public static class Item extends VKModel implements Identifiable {
            public int id;

            @Override
            public int getId() {
                return id;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {

            }
        }

        public static class Subclass extends VKModel {
            public int[] arr;

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {

            }
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    }

}
