# 📰 Mandiri News App

Mandiri News App adalah aplikasi Android yang menampilkan **headline berita** dan **list semua berita** dengan memanfaatkan **REST API dari NewsAPI (newsapi.org)**.  
Aplikasi ini dibuat sebagai bagian dari **Task 5 – Program Rakamin Academy x Bank Mandiri**.

---

## ✨ Fitur Utama
- Menampilkan **headline berita** dari endpoint `/v2/top-headlines`
- Menampilkan **list semua berita** dari endpoint `/v2/everything`
- Konsumsi **REST API** menggunakan Retrofit
- Menampilkan data menggunakan **RecyclerView**
- **Loading state** menggunakan shimmer
- **Infinite scroll** untuk memuat data berita tambahan
- Struktur kode dengan arsitektur **MVVM**

---

## 🛠️ Tech Stack & Library
- **Bahasa**: Kotlin  
- **Arsitektur**: MVVM (Model–View–ViewModel)  
- **Networking**: Retrofit, OkHttp  
- **Asynchronous**: Kotlin Coroutines  
- **UI**: RecyclerView, ViewBinding  
- **Image Loader**: Glide  
- **API**: NewsAPI (newsapi.org)

---

## 📁 Struktur Folder
```
app/src/main/java/com/example/mandiri_news_apps
├── data
│   ├── model
│   └── repository
├── network
│   ├── NewsApi
│   └── RetrofitInstance
├── ui
│   ├── main
│   └── adapter
├── utils
├── helper
```

---

## 🔑 Konfigurasi API Key
Aplikasi ini menggunakan **NewsAPI**, sehingga diperlukan API Key.

API Key disimpan menggunakan **BuildConfig** dan didefinisikan pada file `gradle.properties`.

Tambahkan konfigurasi berikut:
```
NEWS_API_KEY=YOUR_API_KEY_HERE
```

---

## ▶️ Cara Menjalankan Aplikasi
1. Clone repository ini
2. Buka project menggunakan **Android Studio**
3. Tambahkan API Key di file `gradle.properties`
4. Sync Gradle
5. Jalankan aplikasi pada emulator atau device Android

---

## 📱 Preview Aplikasi

<img width="402" height="836" alt="image" src="https://github.com/user-attachments/assets/e89a322b-8fc8-4780-b836-3b210c9d8d95" />
<img width="400" height="832" alt="image" src="https://github.com/user-attachments/assets/f28442f1-5bf5-43e5-ab0b-dedacc163800" />


---

## 📌 Catatan
- Aplikasi ini dibuat untuk keperluan pembelajaran dan portfolio
- Data berita bersumber dari NewsAPI
- Fitur dan tampilan disesuaikan dengan kebutuhan Task 5

---

## 👤 Author
**Febryan Hernanda**  
📧 Email: febryanhernandamashudi@gmail.com  
🌐 Website: https://febryanhernanda.github.io  
💻 GitHub: https://github.com/febryanhernanda  
