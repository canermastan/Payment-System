# Ödeme Sistemi

Bu proje, ArkSigner "T.C. Kimlik Kartı Ve Yüz Tanıma Teknolojileri İle Mobilde Ödeme Hackathon Etkinliği" için hazırlanmış bir Ödeme Sistemidir. Ödeme, kredi kartı bilgileri ve ürün yönetimi için RESTful API'ler içerir. Uygulama Spring Boot kullanılarak geliştirilmiştir ve ödeme işlemleri, kredi kartı bilgileri yönetimi ve ürün bilgilerini yönetme gibi işlevler sunar.



## Özellikler

- **Ödeme İşlemleri**: Kullanıcıların ürünler için ödeme yapmasını sağlar.
- **Kredi Kartı Yönetimi**: Kredi kartı bilgilerini ekleme, alma ve listeleme işlemlerini destekler.
- **Ürün Yönetimi**: Ürün bilgilerini oluşturma, güncelleme ve alma işlemlerini destekler.

## Endpoints

### Ödeme

- **POST /api/payments**
    - Ürün için ödeme işlemi gerçekleştirir.
    - **İstek Gövdesi**:
      ```json
      {
        "productId": 1,
        "creditCardDto": {
        "number": "1234567890123456",
        "expMonth": "12",
        "expYear": "2025",
        "ccv": "123"
        },
        "quantity": 2
      }
      ```
    - **Yanıt**: Ödeme sonucu.

### Kredi Kartı

- **GET /api/cc/get-all**
    - Tüm saklanan kredi kartı bilgilerini alır.
- **POST /api/cc**
    - Yeni bir kredi kartı ekler.
    - **İstek Gövdesi**:
      ```json
      {
        "number": "1234567890123456",
        "expMonth": "12",
        "expYear": "2025",
        "ccv": "123"
      }
      ```
    - **Yanıt**: Kaydedilen kredi kartı bilgileri.
- **GET /api/cc/{number}**
    - Kredi kartı numarasına göre kredi kartı bilgilerini alır.

### Ürün

- **GET /api/products/get-all**
    - Tüm ürünleri alır.
- **POST /api/products**
    - Yeni bir ürün ekler.
    - **İstek Gövdesi**:
      ```json
      {
        "name": "Ürün Adı",
        "description": "Ürün Açıklaması",
        "stock": 100,
        "price": 99.99
      }
      ```
    - **Yanıt**: Kaydedilen ürün detayları.
- **PUT /api/products/{id}**
    - Var olan bir ürünü günceller.
    - **İstek Gövdesi**:
      ```json
      {
        "name": "Güncellenmiş Ürün Adı",
        "description": "Güncellenmiş Ürün Açıklaması",
        "stock": 100,
        "price": 99.99
      }
      ```
    - **Yanıt**: Güncellenmiş ürün detayları.

## Kurulum

1. **Repository'i Klonlayın**:
   ```bash
   git clone https://github.com/kullaniciadi/payment-system.git
   cd payment-system

2. **Uygulamayı Çalıştırın**:
- Java 17'nin kurulu olduğundan emin olun.
- Maven kullanarak uygulamayı çalıştırın:
``` bash
./mvnw spring-boot:run
```