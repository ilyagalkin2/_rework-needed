#Тестовое задание ч.2 /2: Spring Security + PostgreSQL

Пока что отдельно Spring Security и отдельно запросы к БД в </br>
ru/company01/ilyagalkin/controller/HomiesController.java </br>
</br>
</br>
Сервис отправки электронных писем с подтверждением:</br>
https://github.com/maildev</br>
</br>
Раюбота с образом в Docker:</br>
docker run -p 1080:1080 -p 1025:1025 maildev/maildev</br>
</br>
Образ postgres:alpine lkz hf,jns c БД в Docker.</br>
Номер порта конфликтует с обычной PostgreSQL, поэтому 8088</br>
//docker run --name postgres -p 8088:5432 -e POSTGRES_PASSWORD=somepass -e POSTGRES_USER=someuser -e POSTGRES_DB=homies -d postgres:alpine</br>
</br>
</br>
создаёт БД </br>
ru/company01/ilyagalkin/postgresql/postgreSqlCreateTable.java </br>
</br>
заполняет БД для наглядности </br>
ru/company01/ilyagalkin/postgresql/postgreSqlFillTheTable.java </br>
</br>
1	dog	we have found him	boy	Dogie </br>
2	husband	seems always have been here	man	Honey </br>
3	cat	lives here several years already	girl	Kitty </br>
4	cat	we have found him	boy	Qutie </br>
5	children	since the mess around or vice versa	man	Jack </br>
6	kinsfolk	along comes ...and drinks	man	GrandPa </br>
7	children	made him during that baby boom	woman	Mary </br>
</br>
запускает приложение </br>
ru/company01/ilyagalkin/Test02Application.java </br>
</br>
</br>
POST localhost:8080/api/v1/registration
{
"firstName": "user",
"lastName": "a",
"email": "user.a@gmail.com",
"password": "password"
}
</br>
</br>
подтверждение через графический интервейс веб-браузера на localhost:8080, либо запросом
</br>
GET localhost:8080/api/v1/registration/confirm?token=8_______-____-________-___________e
</br>
</br>
Преподаватели, с которыми довелось пообщаться, сказали не 
сходить с ума и учить Spring постепенно. </br>
По Spring Framework и Spring Security в частности подготовил 
учебные материалы (на англ. неплохой бллоггер есть), учу. </br>
</br>