# Veri Yapıları Ve Modelleri - Bölüm 1

## **Algoritma**

- Algoritma; bir problemin çözümünde izlenecek yol anlamına gelir.
- Algoritma, belirli bir problemin çözümü için uygulanacak adımları art arda ve koşulları kesin olarak ortaya koyar. Herhangi bir giriş verisi için bir çıkış verisi elde edilmesi gereklidir.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/60c45c1c-d9a6-4c4d-b116-b3e99f8f9fbe/Untitled.png)

- Bir yazılım geliştirilirken bir çok algoritmaya ihtiyaç duyulabilir. Örneğin;
        - Arama Algoritması,
        - Sıralama Algoritması,
        - Matris ve Vektörel İşlem Algoritması,
        - Graf Algoritması,
        - Matematiksel Model Algoritmaları vb.

## **Veri**

- Veri; algoritmalar tarafınfan işlenen en temel elemanlardır (Sayısal ve metinsel veriler, resimler, sesler vb.)
- Bir algoritmanın etkin, anlaşılır olması ve doğru çalışması için algoritmanın işleyeceği verilerin düzenlenmesi gerekir.

## **Veri Yapıları ve Veri Modelleri**

### **Veri Yapıları**

- **Data Structure**, verinin veya bilginin bellekte tutulma şeklini ve düzenini gösterir.(Veri, olguların harf, sayı, renk gibi sembollerle ifade edilmesi iken, bilgi, herhangi bir konu ile ilgili verilerin bir araya gelmesi ile oluşan açıklayıcı ifadeler bütünüdür.)
      - Tüm programlama dillerinin genel olarak, tam sayı, kesirli sayı, karakter ve sözcük saklanması için temel veri yapıları vardır. Bir program değişkeni bile basit bir veri yapısı olarak kabul edilebilir.

### **Veri Modelleri**

- **Data Model**, verilerin birbirleriyle ilişkisel veya sırasal durumunu gösterir; problemin çözümü için kavramsal bir yaklaşım biçimi olduğu söylenebilir.
      - Bilgisayar ortamında uygulanacak tüm matematik ve mühendislik problemleri bir veri modeline yaklaştırılarak veya yeni veri modelleri tanımlaması yapılarak çözülür.

## Veri Yapılarına Neden İhtiyaç Duyulur?

- Bilgisayar yazılımlarının gün geçtikçe daha karmaşık yapılar alması,
- Yazılımların programlanmasının ve yönetilmesinin zorlaşmasından dolayı ihtiyaç duyuluyor.
- **Temiz kavramsal yapılar** ve bu yapıları sunan çerçeve programları, **daha etkin ve daha doğru** programlar yazmayı sağlar.

### Verimli bir yazılım için

- Temiz, bakımı kolay ve yönetim esaslı bir tasarım,
- Güvenilir,
- Kullanımı kolay,
- **Verimli veri yapıları**,
- **Verimli algoritmalar** olması gereklidir.

Örnek;

- 25 değerini 5 8 12 15 15 17 23 25 27 dizisinde arayalım. Kaç adımda sonuç bulunur?
        - 25 ? 15 15 17 23 25 27
        - 25 ? 23 23 25 27
        - 25 ? 25

## Veri Yapılarının Sınıflandırılması

- Veri yapıları temel olarak ikiye ayrılır;
      - **Temel Veri Yapıları**
        - Temel veri yapıları, daha çok programlama dilleri tarafından doğrudan değişken veya sabit bildirimi yapılarak kullanılır.
      - **Tanımlamalı (Bileşik) Veri Yapıları**
        - Tanımlamalı veri yapıları, kendisinden önceki tanımlamalı veya temel veri yapıları üzerine kurulurlar; önceden geçerli olan veri yapıları kullanılarak sonradan tanımlanırlar.
- Programlama dilinin elverdiği ölçüde, hemen her tür veri yapısı tanımlanabilir. C programlama dilinde yeni veri yapısı tanımlamak için [***struct***](https://en.wikipedia.org/wiki/Struct_(C_programming_language)#:~:text=A%20struct%20in%20the%20C,declared%20name%20which%20returns%20the), [***union***](https://www.tutorialspoint.com/cprogramming/c_unions.htm) gibi birkaç deyim vardır.
- Aşağıdaki bildirime göre **tam, kr** ve **kesirli** değişkenler, C programlama dilinde birer temel veri yapısıdır; ancak **toplam** adlı değişken ise, tanımlamalı veri yapısı şeklindedir. “struct karmasik” adlı veri yapısının 2 tane üyesi vardır; biri **gerçel**, diğeri **sanal** kısmı tutması için kullanılır.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/d2d05231-efd5-42a6-88f3-45fe52f6b140/Untitled.png)

### Temel Veri Yapıları

- Tüm programlama dillerinin, genel olarak, karakter, tamsayı, kesirli sayı ve sözcük (karakter katarı) saklanması için temel veri yapıları vardır. Veri yapısı, aslında, ham olarak 1 ve 0’lardan oluşan verinin yorumlanmasını belirleyen biçimleme (formating) düzenidir. Örneğin, 62 sayısının ikili tabandaki karşılığı, 111110 olarak bellekte saklanır.
      - 111110 ikili tabanda hesaplamak için, sağ baştan her rakamın üzerine 0’dan itibaren sırayla rakamlar yazılır. Sonrasında 0’ıncı rakam çarpı 2 üzeri sıfır yapılır ve devam edilir.
        - $0*2^0 + 1*2^1 + 1*2^2 + 1*2^3 + 1*2^4 + 1*2^5 = 62$
      - Temel veri yapıları aşağıdaki gibi sınıflanabilir:

    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/3dcf31a3-2695-4f41-bcbb-caab4d3d69c9/Untitled.png)

### Tanımlamalı Veri Yapıları

- Tanımlamalı veri yapısı, üç değişik şekilde yapılabilir;
      - **Topluluk (Struct) Oluşturma:** Birden çok veri yapısı bir araya getirilip yeni bir veri yapısı ortaya çıkarmaktır. Örneğin Java dilindeki sınıflar.
      - **Ortaklık (Union) Oluşturma**: Birden çok değişkenin aynı bellek alanını kullanmasını sağlayan veri yapısı tanımlamasıdır. Ortaklıkta en fazla yer işgal eden veri yapısı hangisi ise, ortaklık içerisindeki tüm değişkenler orayı paylaşır.
      - **Bit Düzeyinde Erişim**: Verinin her bit’i üzerinde diğerlerinden bağımsız olarak işlem yapılması olanağı sunar.
- Her birinin kullanım amacı farklı olup uygulamaya göre bir tanesi veya hepsi bir arada kullanılabilir. Genel olarak, en çok kullanılanı topluluk oluşturmadır; böylece birden fazla veri yapısı bir araya getirilip/paketlenip yeni bir veri yapısı/türü ortaya çıkarılır.
- C dilindeki tanımlamalı veri yapılarına örnek olarak;

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/159680e9-3323-4b57-89a4-f32d6a45acc6/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/94d6a8df-264c-498e-8316-5bd16508f46f/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/0dd412ff-e5b4-4576-b39c-fecd0e83e34c/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/84e7ac60-0f10-4c8f-8f15-ca7395351310/Untitled.png)

## Veri Modelleri

Veri modelleri, bir programın en uygun ve etkili şekilde tasarlanmasını sağlar ve genellikle programın çalışma hızı ile bellek gereksinimi arasında doğru bir ilişki vardır. Çoğu zaman, programın çalışma hızı arttıkça bellek gereksinimi de artar. Bu nedenle, programın başlangıcından itibaren veri modelleri kullanarak, hem çalışma hızı hem de bellek gereksinimi hakkında önemli bilgiler elde edilebilir.

- Veri modelleri genel olarak;
        - **Bağlantılı Liste (Link List)**
        - **Ağaç (Tree)**
        - **Graf (Graph)**
        - **Durum Makinası (State Machine)**
        - **Veritabanında İlişkisel (Database Relational)**
        - **Ağ Bağlantı (Network Connection)**

        ![**Hız ile Bellek Miktarı arasında denge kurulması**](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/444dbd41-a937-471b-a426-59396d0e4d9d/Untitled.png)

        **Hız ile Bellek Miktarı arasında denge kurulması**

### Liste ve Bağlantılı Liste Veri Modeli

- Liste veri modeli, aynı kümeye ait olan verilerin bellekte art arda tutulması ilkesine dayanır. Veriler belirli bir düzen içerisinde (sıralı vs.) olabilir veya olmayabilir; önemli olan tüm verilerin art arda gelen sırada tutulmasıdır.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/459ee127-e199-4e74-85de-3060b4152d28/Untitled.png)

- En yalın liste veri modeli, bir boyutlu liste üzerinde tutulandır. Böylesi bir listeye eleman ekleme işlemi oldukça kolaydır; genel olarak, yeni gelen elemanlar listenin sonuna eklenir. Yalın listede bir sonraki eleman hemen o elemanın işgal ettiği bellek alanından sonradır.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/bb749e4e-eaf7-4ae5-8368-d14d887dbae7/Untitled.png)

- Bağlantılı (Link List) ise, elemanların kendi değerlerine ek olarak birde bağlantı bilgisinin kullanılmasıyla sağlanır; bağlantı bilgisi bir sonraki elemanın adresi niteliğindedir.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/c6d6f7ee-5f72-420d-9c1d-3dfc5f2fff1a/Untitled.png)

### Ağaç Veri Modeli

- Ağaç veri modeli, düğümlerden ve dallardan oluşur; düğümlerde verilerin bir kısmı tutulurken dallar diğer verilerin

- En üstteki düğüm kök (root), kendisine alttan hiçbir bağlantının olmadığı düğüm yaprak (leaf), diğerleri de ara düğüm (internal node) olarak adlandırılır. Bir düğüme alttan bağlı düğümlere çocuk (child), üsten bağlı düğüme de o düğümün ailesi (parent) denilir.

![Untitled.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/d2918a90-02a0-4a9a-a5f0-016b3d1191d8/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/f1b22062-ccf3-44a9-ab2b-02ff80efbf15/Untitled.png)

### Graf Veri Modeli

- Graf veri modeli, aynı kümeye ait olan verilerin şekilde görüldüğü gibi düğümler, ayrıtlar (kenarlar) ve bunların birleştirilmesinden oluşur. Düğümler birleşme noktasını ayrıtlar da düğümlerin bağlantı ilişkisini gösterir. Verilerin kendileri veya bir kısmı hem düğümlerde hem de ayrıtların bilgi kısmında tutulabilir.

- Graflar, yazılım dünyasından önemli bir yere sahiptir. Örneğin, bir şehrin trafik altyapısından en yüksek akışın sağlanması, taşıma şirketinin en verimli taşıma şekli veya network bağlantılarında yüksek başarım elde edilmesi gibi problemler.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/86bffd9b-c595-4146-91d4-b0f791b6584b/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/a6ecf0c6-e4b6-463e-bd30-c9567fe00be0/Untitled.png)

### Durum Makinası Veri Modeli

- Durum makinaı veri modeli, bir sistemin davranışını tanımlamak ve ortaya çıkarmak için kullanılan yaklaşım şeklidir; işletim sistemlerinde, derleyici ve yorumlayıcılarda, kontrol amaçlı yazılımlarda sistemin davranışını durumlara indirger ve durumlar arası geçiş koşullarıyla sistemi ortaya koyar.
- Durum makinasının yazılım uygulamasında birçok kullanım alanı vardır. Örneğin;
        - Bir robot kolunun hareketinde,
        - Şifre çözmede,
        - Gerçek zamanlı işletim sistemlerinde process kontrolünde,
        - Genel olarak kontrol alt sistemlerinin yazılımla uygulamayı başarılı bir şekilde sonuçlandırma durumlarında çözüm olur.
- Durum makinası veri modeli şeklen yönlü graflara benzer, ancak birleşme noktaları graflarda olduğu gibi düğüm değil **durum**, ayrıtlar da **geçiş eğrileri** olarak adlandırılır. Durumlar arası geçişler, sistemin o ana kadarki durum ve giriş parametrelerine bağlıdır.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/e52effc7-fb82-4605-8855-8379a6b01b5c/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/95cc46d7-031b-420f-8fa5-9c5cf851a624/Untitled.png)

### Veritabanında İlişkisel Veri Modeli

- Veritabanı ilişkisel veri modeli veritabanı uygulamalarında var olan sınıflardan biridir. Veriler şekillerde gösterildiği gibi tablolar üzerinden kurulan ilişkilere dayanmaktır.

    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/0c061bde-90e2-4a8b-873e-cff5c017bbc3/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/7e7dfa5b-94ca-423e-9286-0941e6d7877a/Untitled.png)

- SQL (Structured Query Language) sorgulama dili ile veritabanı üzerinde sorgu yapılabilir. Access, Microsoft SQL, ORACLE, SYBASE, Ingres gibi birçok veritabanı yönetim sistemleri ilişkisel veri modelini desteklemektedir.
- Veritabanı yönetim sistemleri, veritabanı oluşturma, tablo yaratma, alanları tanımlama gibi işlerin başarılı bir şekilde sonuçlandırması ve genel olarak veritabanı yönetimini sağlarlar.

### Ağ Veri Modeli

- Ağ veri modeli, katmanlı ağ mimarilerinde bilgisayarlar arasında eş katmanlar düzeyinde veri alışverişini sağlayan dilim, paket ve çerçeve yapılarını tanımlar. Veri iletişiminde neredeyse tüm ağ mimarileri katmanlı bir yapıya sahiptir. Örnek olarak, OSI modeli 7 katmandan, TCP/IP protokol kümesi ise 4 katmandan oluşur.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/339d3725-283d-4b87-8db7-719112e20a49/9793ae9d-9bb9-4c10-a9c3-11a94349dc04/Untitled.png)

### Veri Modellerinde İşlenecek Modeller

1. **Liste**: Sonlu sayıda elemandan oluşan ve elemanları **doğrusal sırada** yerleştirilmiş veri modeli. Herhangi bir elemanına erişimde sınırlama yoktur.
2. **Yığıt veya Yığın**: Elemanlarına erişim sınırı olan, liste uyarlı veri modeli(Last In First Out-LIFO listesi).
3. **Kuyruk**: Elemanlarına erişim sınırı olan, liste uyarlı veri modeli(First In First Out-FIFO listesi).
4. **Ağaç**: **Doğrusal olmayan** belirli niteliklere sahip veri modeli.
5. **Çizge(Graph)**: Köşe adı verilen düğümleri ve kenar adı verilen köşeleri birbirine bağlayan bağlantılardan oluşan **doğrusal olmayan** veri modeli.

| Veri Yapıları | Artıları | Eksileri |
| --- | --- | --- |
| Dizi | Hızlı ekleme ve erişim(indisleri biliniyorsa) | Yavaş arama ve silme, sabit boyut |
| Sıralı Dizi | Sıralanmamış diziye göre daha hızlı arama | Yavaş arama ve silme, sabit boyut |
| Yığın | Son giren, ilk çıkar(Last-in,first-out) erişimi sağlar | Diğer öğelere yavaş erişim |
| Kuyruk | İlk giren ilk çıkar (first-in,first-out) erişimi sağlar | Diğer öğelere yavaş erişim |
| Bağlı Liste | Hızlı ekleme ve silme | Yavaş arama |
| Hash Tablosu | Hızlı ekleme ve anahtar bilindiğinde çok hızlı erişim | Yavaş silme, anahtar bilinmediğinde çok yavaş erişim ve verimsiz bellek kullanımı |
| Küme(Heap) | Hızlı ekleme ve silme | Diğer öğelere yavaş erişim ve ilk önce en büyük öğeye erişim |
| İkili Ağaç | Hızlı arama, ekleme ve silme (ağaç yapısı dengeli kalmışsa) | Silme algoritması karışık |
| Graf | Gerçek dünya problemlerini modelleyebilmesi | Bazı algoritmaların yavaş çalışması ve yüksek karmaşıklık |
