# Backend Automation Testing - Katalon Studio (API & Apache Kafka)

Proyek ini merupakan repositori **Uji Kemampuan Teknis (Technical Test)** untuk posisi Quality Assurance Engineer. Proyek otomatisasi ini dibangun menggunakan **Katalon Studio Enterprise** untuk memvalidasi alur integrasi pada **RESTful API** dan arsitektur messaging menggunakan **Apache Kafka**.

---

## 🚀 Fitur & Skenario Pengujian

Proyek ini mencakup pengujian backend end-to-end (E2E) yang dibagi menjadi dua skenario utama yang dikelompokkan dalam satu Test Suite (`TS_Backend_Verification_Suite`):

### 1. RESTful API Automation (Producer & Consumer)
*   **File:** `Test Cases/TC_01_REST_API_Validation`
*   **Peran Katalon sebagai Producer:** Mengirimkan data payload baru menggunakan metode **POST** ke endpoint mockup (`https://jsonplaceholder.typicode.com/posts`).
*   **Peran Katalon sebagai Consumer:** Menangkap (*parsing*) ID dinamis yang dihasilkan dari respons server, kemudian menggunakan metode **GET** untuk mengambil data dan memastikan integritas data (*response status code 200* dan validasi nilai properti objek).

### 2. Apache Kafka Automation (Consumer Only)
*   **File:** `Test Cases/TC_02_Kafka_Consumer_Validation`
*   **Custom Keyword:** `com.qa.kafka.KafkaConsumerHelper`
*   **Peran Katalon sebagai Consumer:** Memanfaatkan pustaka Java eksternal (`kafka-clients`) untuk terhubung ke broker Kafka, melakukan *polling* ke topik tertentu (`qa-test-topic`), mengonsumsi pesan terbaru (*latest message*), dan melakukan asersi terhadap isi payload pesan tersebut.

---

## 🛠️ Tech Stack & Dependensi

*   **Automation Tool:** Katalon Studio Enterprise v11.x
*   **Language:** Groovy / Java
*   **External Driver:** `kafka-clients-4.3.1.jar` (Tersimpan di dalam folder `Drivers/`)
*   **Target Endpoint API:** JSONPlaceholder (Public Mock API)

---

## 📂 Struktur Proyek

```text
Katalon-technical-test/
│
├── Drivers/
│   └── kafka-clients-4.3.1.jar       # Driver eksternal untuk koneksi Apache Kafka
│
├── Object Repository/
│   ├── POST_Create_Post.rs           # REST Request untuk scenario Producer
│   └── GET_Post_By_ID.rs             # REST Request untuk scenario Consumer
│
├── Test Cases/
│   ├── TC_01_REST_API_Validation     # Alur pengujian REST API
│   └── TC_02_Kafka_Consumer_Validation # Alur pengujian Kafka Consumer
│
├── Test Suites/
│   └── TS_Backend_Verification_Suite # Suite gabungan untuk eksekusi pengujian
│
└── .gitignore                        # Konfigurasi pengabaian file sampah Git


