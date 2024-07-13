import java.util.Scanner;

public class Hanoikuleleri {

    public static void main(String[] args) {
        // Kullanıcıdan disk sayısını al
        System.out.print("n değerini giriniz: ");
        Scanner klavye = new Scanner(System.in);
        int n = klavye.nextInt();
        klavye.close();

        // Hanoi Kuleleri çözümünü başlat
        tasi(n, 'A', 'B', 'C');
    }

    // n diskini A çubuğundan B çubuğuna C çubuğunu kullanarak taşıma
    public static void tasi(int n, char A, char B, char C) {
        if (n == 1) {
            // Temel durum: tek bir disk, doğrudan taşınır
            System.out.println(A + " --> " + B);
        } else {
            // Adım 1: n-1 diski A'dan C'ye B'yi kullanarak taşı
            tasi(n - 1, A, C, B);

            // Adım 2: 1 diski A'dan B'ye taşı
            System.out.println(A + " --> " + B);

            // Adım 3: n-1 diski C'den B'ye A'yı kullanarak taşı
            tasi(n - 1, C, B, A);
        }
    }
}

/*
 * Bu kodu adım adım açıklayalım:

	1.	Paket ve İthalat:
	•	package hanoikuleleri;: Sınıfın hangi pakette olduğunu belirtir.
	•	import java.util.Scanner;: Kullanıcıdan girdi almak için Scanner sınıfını ithal eder.
	2.	Ana Sınıf ve Metod:
	•	public class Hanoikuleleri: Sınıf tanımı.
	•	public static void main(String[] args): Programın giriş noktası olan ana metod.
	3.	Kullanıcı Girdisi Alma:
	•	Scanner klavye = new Scanner(System.in);: Kullanıcıdan girdi almak için Scanner nesnesi oluşturur.
	•	int n = klavye.nextInt();: Kullanıcının girdiği disk sayısını okur.
	•	klavye.close();: Scanner nesnesini kapatır.
	4.	Hanoi Kuleleri Çözümü:
	•	tasi(n, 'A', 'B', 'C');: Diskleri A çubuğundan B çubuğuna C çubuğunu kullanarak taşıma işlemini başlatır.
	5.	Özyinelemeli Metod:
	•	public static void tasi(int n, char A, char B, char C): Diskleri taşımak için özyinelemeli metod.
	•	if (n == 1): Temel durum, eğer sadece bir disk varsa, diski doğrudan A’dan B’ye taşır.
	•	else: Daha büyük bir problem, üç adımda çözülür:
	1.	tasi(n - 1, A, C, B);: n-1 diskini A’dan C’ye B’yi kullanarak taşı.
	2.	System.out.println(A + " --> " + B);: Kalan 1 diski A’dan B’ye taşı.
	3.	tasi(n - 1, C, B, A);: n-1 diskini C’den B’ye A’yı kullanarak taşı.

Bu yöntem, özyineleme kullanarak Hanoi Kuleleri problemini etkili bir şekilde çözer ve disklerin
nasıl taşınacağını adım adım gösterir.
 */