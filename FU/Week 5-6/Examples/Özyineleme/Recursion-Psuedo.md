# Özyineleme

Özyineleme ve "Böl ve Yönet" stratejisi, büyük bir problemi daha küçük alt problemlere bölerek çözmeyi ve bu alt problemlerin çözümlerini birleştirerek orijinal problemi çözmeyi amaçlar. Bu yöntem, birçok algoritmada yaygın olarak kullanılır. İşte bu stratejiyi anlatan bir kod parçası ve detaylı açıklaması:

```java
// Özyineleme ve "Böl ve Yönet" stratejisi ile problemi çöz
public Çözüm solve(Problem P) {
    // Temel durum: Eğer P problemi temel durumda ise çözümü döndür
    if (P.temelDurum()) {
        return P.temelÇözüm();
    }

    // Problemi daha küçük parçalara böl (n >= 2 olmalı)
    List<Problem> altProblemler = P.böl();

    // Alt problemleri özyinelemeli şekilde çöz
    List<Çözüm> altÇözümler = new ArrayList<>();
    for (Problem altProblem : altProblemler) {
        Çözüm altÇözüm = solve(altProblem);
        altÇözümler.add(altÇözüm);
    }

    // Alt çözümleri birleştirerek orijinal problemin çözümünü elde et
    Çözüm çözüm = merge(altÇözümler);

    // Çözümü geri döndür
    return çözüm;
}

// Alt çözümleri birleştiren yardımcı fonksiyon
private Çözüm merge(List<Çözüm> altÇözümler) {
    // Bu metodun içeriği probleme bağlıdır
    // Örneğin, alt çözümleri sıralı bir şekilde birleştirmek
    // veya alt çözümlerden maksimum/minimum değeri bulmak gibi işlemler yapılabilir.
    // Burada örnek bir birleştirme işlemi:
    Çözüm birleşikÇözüm = new Çözüm();
    for (Çözüm altÇözüm : altÇözümler) {
        birleşikÇözüm.birleştir(altÇözüm);
    }
    return birleşikÇözüm;
}
```

Bu kodu adım adım açıklayalım:

1. **Temel Durum Kontrolü:**
   - `if (P.temelDurum())` satırında, eğer problem `P` bir temel durumsa (yani daha fazla bölünemeyecek kadar küçükse), doğrudan çözümü döndürülür. `P.temelÇözüm()` ile temel çözüm elde edilir.

2. **Problemi Bölme:**
   - `P.böl()` metodu, problemi daha küçük alt problemlere böler. Bu alt problemler `altProblemler` listesinde tutulur.

3. **Alt Problemleri Çözme:**
   - `for (Problem altProblem : altProblemler)` döngüsünde, her bir alt problem için `solve(altProblem)` çağrısı yapılır. Bu çağrı, alt problemi özyinelemeli olarak çözer.
   - Her bir alt çözüm `altÇözümler` listesine eklenir.

4. **Çözümleri Birleştirme:**
   - `merge(altÇözümler)` metodu, alt çözümleri birleştirerek orijinal problemin çözümünü oluşturur.
   - Bu birleştirme işlemi, probleme özgü olabilir. Örneğin, iki sıralı listeyi birleştirmek veya bir arama ağacında birleşme işlemleri yapmak gibi.

5. **Çözümü Geri Döndürme:**
   - Son olarak, birleştirilmiş çözüm döndürülür.

Bu yöntem, "Böl ve Yönet" stratejisinin genel yapısını ve özyinelemeli düşünme tarzını gösterir. Örneğin, bu strateji Merge Sort, Quick Sort, ve Binary Search gibi algoritmalarda kullanılır.