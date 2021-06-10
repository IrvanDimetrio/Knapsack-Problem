# Knapsack-Problem
Di program ini terdapat beberapa penyelesaian untuk Knapsack Problem, antara lain ada :

Contoh Permasalahan yang ingin dipecahkan sebagai berikut :

Berat/weight benda = {100, 50, 45, 20, 10, 5}

Nilai kegunaan/values benda= {40, 35, 18, 4, 10, 2}

Dari berbagai benda diatas kita harus menentukan barang terbaik apa yang harus kita bawa/ambil dengan maksimal berat yang dapat dibawa adalah 160

## 1. Knapsack secara umum atau biasa (Knapsack.java)
Dengan output sebagai berikut :

![image](https://user-images.githubusercontent.com/52452132/121336067-5d4a2a00-c945-11eb-8436-77adbf856dda.png)

## 2. Knapsack Backtracking

![image](https://user-images.githubusercontent.com/52452132/121469677-1d3b8380-c9e7-11eb-9a53-fd68603639c7.png)

### Dengan output sebagai berikut pada bahasa Java :

![image](https://user-images.githubusercontent.com/52452132/121338396-aac79680-c947-11eb-961e-2d15ece80703.png) ![image](https://user-images.githubusercontent.com/52452132/121338477-bd41d000-c947-11eb-86dd-f8edebd88f1c.png) ![image](https://user-images.githubusercontent.com/52452132/121338541-ce8adc80-c947-11eb-83b9-d36d465764ee.png)

--------------

![image](https://user-images.githubusercontent.com/52452132/121338626-e06c7f80-c947-11eb-9b28-45280dcb7468.png) 
![image](https://user-images.githubusercontent.com/52452132/121338691-f11cf580-c947-11eb-80c6-e2d2fc844012.png)

### Dengan output sebagai berikut pada bahasa Python :

![image](https://user-images.githubusercontent.com/52452132/121469552-e5344080-c9e6-11eb-8504-4d1db0b03a60.png)

## 3. Knapsack Branch and Bound 
Metode Branch and Bound adalah sebuah teknik algoritma yang secara khusus mempelajari bagaimana caranya memperkecil Search Tree menjadi sekecil mungkin.
Sesuai dengan namanya, metode ini terdiri dari 2 langkah yaitu :
1.	Branch yang artinya membangun semua cabang tree yang mungkin menuju solusi.
2.	Bound yang artinya menghitung node mana yang merupakan active node (E-node) dan node mana yang merupakan dead node (D-node) dengan menggunakan syarat batas constraint (kendala).
Digunakan untuk persoalan optimisasi → meminimalkan atau memaksimalkan suatu fungsi objektif, yang tidak melanggar batasan (constraints) persoalan

![image](https://user-images.githubusercontent.com/52452132/121469780-4d832200-c9e7-11eb-9a8a-d684d249cec2.png)

### Dengan output sebagai berikut pada bahasa Java:

![image](https://user-images.githubusercontent.com/52452132/121340082-6210dd00-c949-11eb-86ef-74ff6195a56b.png)

### Dengan output sebagai berikut pada bahasa Python:

![image](https://user-images.githubusercontent.com/52452132/121469854-6d1a4a80-c9e7-11eb-82e7-570ee292d0ad.png)

## 4. Knapsack Dynamic Programming
Dynamic programming dapat didefinisikan sebagai suatu pendekatan matematik yang memiliki prosedure sistematis yang dirancang sedemikian rupa dengan tujuan untuk mengoptimalkan penyelesaian suatu masalah tertentu yang diuraikan menjadi sub-sub masalah yang lebih kecil yang terkait satu sama lain dengan tetap memperhatikan kondisi dan batasan permasalahan tersebut.
Struktur dynamic programming untuk dapat dimengerti secara lebih jelas dan lebih spesifik, umumnya dideskripsikan dengan suatu sistem notasi. Struktur dynamic programming disebut juga dengan model dynamic programming. Notasi dan simbol yan digunakan dalam model dynamic programming adalah beragam, namun secara umum dapat dinyatakan sebagai berikut :
i	= Tahap keputusan ke - i.
n	= Banyak tahap keputusan.
Xi	= Variable keputusan pada tahap keputusan ke – i. Si(Si – 1, Xi) = Status pada tahap keputusan ke – i.
ri(Si,Xi)	= Return pada tahap keputusan ke – i.
fi(Si,Xi)	= Nilai keputusan pada tahap keputusan ke – i, untuk status Si dan variable keputusan Xi.
fi*(Si)	= Nilai keputusan optimal pada tahap keputusan ke – i, untuk status Si.

* Struktur dan Sistem Notasi Dynamic Programming
![image](https://user-images.githubusercontent.com/52452132/121469976-a5ba2400-c9e7-11eb-9207-168123dfa4d6.png)

Pada umumnya dynamic programming digunakan untuk masalah optimisasi. Dimana suatu permasalahan memiliki banyak solusi. Setiap solusi memiliki nilai masing-masing dan ingin ditemukan solusi dengan nilai yang optimum (maksimal atau mininal). Dynamic programming dapat dibagi menjadi empat tahap yang berurutan sebagai berikut :
1.	Karakterisasi struktur pada solusi optimasi
2.	Mendefinisikan nilai solusi optimal secara rekursif
3.	Menghitung nilai solusi optimal pada model bottom-up
4.	Menyusun solusi optimal dari informasi hasil perhitungan

### Dengan output sebagai berikut pada bahasa Java :

![image](https://user-images.githubusercontent.com/52452132/121340331-b2883a80-c949-11eb-8e59-8721e7ab32e8.png)

### Dengan output sebagai berikut pada bahasa Python :

![image](https://user-images.githubusercontent.com/52452132/121470071-d39f6880-c9e7-11eb-806b-8f0464286d9a.png)
