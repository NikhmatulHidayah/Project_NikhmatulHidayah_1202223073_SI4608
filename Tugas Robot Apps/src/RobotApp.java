// Mengimpor kelas-kelas yang diperlukan
import java.util.Scanner;
import Model.Layout;
import Model.Position;
import Model.Robot;

// Deklarasi kelas utama RobotApp
public class RobotApp {
    public static void main(String[] args){
        // Membuat instance baru dari RobotApp
        new RobotApp();
    }

    /*
     * Perintah Soal:
     * Anggap 'o' adalah sebuah robot yang berada didalam area permainan.
     * Buat robot dapat bergerak ke kiri/kanan/atas/bawah sesuai jumlah langkah yang diinstruksikan.
     * Format instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah} dan 'x' untuk keluar aplikasi *case sensitive
     * Robot tidak boleh keluar dari area permainan dan buat pesan kesalahannya.
     * Buat pesan kesalahan jika pengguna tidak menulis instruksi dengan benar.
     * Lanjut pada perintah soal dibawah.
     */

    // Deklarasi variabel layout, robot, dan scanner
    private Layout layout;
    private Robot robot;
    private Scanner scanner;

    // Konstruktor RobotApp
    public RobotApp() {
        // Inisialisasi layout dengan ukuran 10x10 dan icon area kosong '*'
        this.layout = new Layout(10, 10, '*');
        // Inisialisasi scanner untuk input
        this.scanner = new Scanner(System.in);
        // Menempatkan robot pada posisi awal (1,1) dengan icon 'x'
        Position posisiawal = new Position(1, 1);
        this.robot = new Robot('x', posisiawal);

        // Deklarasi variabel untuk menyimpan instruksi
        String instruction = "";
        // Menampilkan pesan permainan dimulai
        System.out.println("-------- Permainan Dimulai --------");
        // Perulangan permainan
        do{
            // Memanggil metode untuk menampilkan posisi terbaru
            draw();
            // Menunggu input instruksi dari pengguna
            instruction = waitInstruction();

            // Deklarasi variabel untuk menyimpan jumlah langkah dan arah gerakan
            int berapalangkah = 0;
            String jalankemana = instruction.substring(0, 1);

            // Validasi instruksi tidak sama dengan 'x'
            if (!instruction.equals("x")) {
                try {
                    // Mengambil jumlah langkah dari instruksi
                    berapalangkah = Integer.parseInt(instruction.substring(1));
                    // Validasi jumlah langkah tidak boleh negatif
                    if (berapalangkah < 0) {
                        System.out.println("Jumlah langkah tidak boleh negatif. Harap masukkan jumlah langkah yang valid.");
                        return; // Menghentikan program jika jumlah langkah tidak valid
                    }
                } catch (NumberFormatException e) {
                    // Menangani exception jika format langkah tidak valid
                    System.out.println("Format langkah tidak valid. Harap masukkan jumlah langkah yang valid.");
                    return; // Menghentikan program jika format langkah tidak valid
                }
            } else {
                // Menampilkan pesan keluar dari aplikasi karena perintah invalid.
                System.out.println("Keluar dari aplikasi karena perintah invalid.");
                break; // Keluar dari perulangan jika instruksi adalah 'x'
            }

            // Menyimpan posisi baru robot
            int newX = robot.getPosition().getX();
            int newY = robot.getPosition().getY();

            // Menggunakan switch untuk menentukan arah gerakan dan mengupdate posisi baru
            switch (jalankemana) {
                case "w":
                    newY -= berapalangkah;
                    break;
                case "a":
                    newX -= berapalangkah;
                    break;
                case "s":
                    newY += berapalangkah;
                    break;
                case "d":
                    newX += berapalangkah;
                    break;
            }

            // Validasi posisi baru tidak keluar dari area permainan
            if (newX >= 0 && newX < layout.getMaxX() && newY >= 0 && newY < layout.getMaxY()) {
                // Mengupdate posisi robot jika valid
                robot.getPosition().setX(newX);
                robot.getPosition().setY(newY);
            } else {
                // Menampilkan pesan robot tidak boleh keluar dari area permainan dan menghentikan permainan
                System.out.println("Robot tidak boleh keluar dari area permainan.");
                break;
            }

        } while (!instruction.equals("x")); // Keluar dari perulangan jika instruksi adalah 'x'
        // Menampilkan pesan permainan selesai setelah keluar dari perulangan
        System.out.println("-------- Permainan Selesai --------");
    }

    // Metode untuk menunggu instruksi dari pengguna
    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'keatas 3 langkah'");
        System.out.print("Masukan instruksi: ");
        return scanner.nextLine();
    }

    // Metode untuk menampilkan posisi terbaru robot dan area permainan
    private void draw() {
        System.out.println("------ Posisi Terbaru ------");
        /*
        Gambar layout:
        Contoh:
        - Posisi robot di 1,1
        - Area permainan luasnya 10,10
        sehingga gambar layout akan menjadi:

            o*********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********

            - konfigurasi (icon robot, posisi robot, luas area dan icon area permainan yang tidak ditempati robot) silahkan gunakan prinsip OOP
            - icon cukup menggunakan karakter yang ada di keyboard.
         */
        
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                // Mengecek apakah koordinat saat ini adalah posisi robot
                if(a == robot.getPosition().getY() && b == robot.getPosition().getX())
                {
                    System.out.print(robot.getIcon());
                }
                else
                {
                    System.out.print(layout.getArea()[a][b]);
                }
            }
            System.out.println();
        }
    }
}
