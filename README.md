# Öğrenci Otomasyonu - Web Arayüzü

Bu proje, senin verdiğin konsol tabanlı Java sınıflarını (Person, Student, Teacher,
Course, Grade, Attendance, Enrollment ve Manager sınıfları) temel alarak
**Spring Boot + Thymeleaf** ile geliştirilmiş web tabanlı bir arayüzdür.

## Ne değişti?

- Model sınıfların (Student, Teacher, Course, Grade, Attendance, Enrollment)
  mantığı aynı kaldı; sadece web formlarından veri alabilmek için boş (no-arg)
  constructor eklendi, `Grade` ve `Attendance`'a `id` alanı eklendi.
- `StudentManager`, `TeacherManager`, `CourseManager` sınıfların Spring
  `@Service` bean'ine çevrildi (`students.add(...)`, `findStudent(...)` gibi
  metodların hepsi aynı, sadece artık Spring tarafından yönetiliyor).
- `GradeManager`, `AttendanceManager`, `EnrollmentManager` yeni eklendi
  (senin sınıflarında bu işlemler için ayrı bir "manager" yoktu).
- `Grade.calculateLetterGrade()` metodu `System.out.println` yerine ekranda
  gösterilebilmesi için `getLetterGrade()` adıyla `String` döndürecek şekilde
  ayrıca eklendi (harf notu sınır kontrolündeki küçük boşluk hatası da
  düzeltildi, örn. ortalama tam 85 olan öğrenci artık boşlukta kalmıyor).
- `Main.java` (konsol menüsü) kaldırıldı, yerine web sayfaları ve
  Controller sınıfları geldi.

## Özellikler

- **Öğrenciler**: listele, ekle, düzenle, sil
- **Öğretmenler**: listele, ekle, düzenle, sil
- **Dersler**: listele, ekle, düzenle, sil, öğretmen ata
- **Ders Detayı**: derse öğrenci kaydet, devamsızlık ekle
- **Notlar**: vize/final notu gir, ortalama ve harf notunu otomatik göster

## Nasıl çalıştırılır

Gerekenler: **Java 17+** ve **Maven** (internet bağlantısı, bağımlılıkları
indirmek için gerekli).

```bash
cd studentautomation
mvn spring-boot:run
```

Uygulama ayağa kalktıktan sonra tarayıcıdan:

```
http://localhost:8080
```

adresine gidip arayüzü kullanabilirsin.

### IntelliJ IDEA / Eclipse ile açmak

Projeyi bir Maven projesi olarak aç (pom.xml dosyasını seç), bağımlılıklar
otomatik inecektir. Ardından `StudentAutomationApplication.java` dosyasını
çalıştırman yeterli.

## Not

Veriler şu an **bellekte (in-memory)** tutuluyor — yani uygulamayı her
yeniden başlattığında kayıtlar sıfırlanır (tıpkı orijinal konsol
uygulamasında olduğu gibi). İstersen bir sonraki adımda bunu bir
veritabanına (H2 / MySQL) bağlayıp kalıcı hale getirebiliriz.
