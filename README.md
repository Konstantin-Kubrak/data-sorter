Инструкция по запуску:<br>
Утилита принимает файлы с расширением txt.<br>
Не предназначена для работы с файлами большого объёма ввиду того, 
что информация из файлов в процессе работы аккумулируется приложением (при необходимости, возможна реализация работы с большими файлами). <br>
В качестве разделителя строк в файле должен использоватся перевод строки. <br>
По умолчанию файлы с результатами располагаются в текущей папке с именами integers.txt, floats.txt, strings.txt.<br>
<br>
Опция -o задаёт путь для результатов. В случае, если указанный путь не существует - будет использован путь по умолчанию.<br>
Опция -p задает префикс имен выходных файлов. Например -o /some/path -p result_ задают вывод в
файлы /some/path/result_integers.txt, /some/path/result_strings.txt и тд.<br>
Опция -a устанавливает режим добавления в существующие файлы. По умолчанию файлы результатов перезаписываются.<br>
Опции -s и -f задают вывод стастистики в консоль, короткую и полную соответственно. При отсутствие данных "флагов" статистика не будет выведена.<br>

Файлы с результатами создаются по мере необходимости. Если какого-то типа
данных во входящих файлах нет, то исходящий файл, который будет заведомо
пустым, не будет создан.<br>

В приложении использована система сборки проекта Maven.<br>
• версия Java – 17 
• система сборки – Maven;
• сторонние библиотеки – maven-jar-plugin, версия 3.1.1