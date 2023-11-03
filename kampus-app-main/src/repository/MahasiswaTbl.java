package repository;

import model.Mahasiswa;
import model.Prodi;

public class MahasiswaTbl {
    private Database db;

    public MahasiswaTbl(Database db) {
        this.db = db;
    }

    public void create(String nim, String nama, String idProdi) {
        Prodi prodi = getProdiByID(idProdi);
        if (prodi != null) {
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, prodi);
            db.getTables().dataMahasiswa.add(mahasiswa);
            db.commit();
        } else {
            System.out.println("Prodi dengan ID " + idProdi + " tidak ditemukan.");
        }
    }


    public void update(String nimLama, Mahasiswa mahasiswaBaru) {
        Mahasiswa mahasiswaToUpdate = getMahasiswaByNim(nimLama);

        if (mahasiswaToUpdate != null) {
            Prodi prodiBaru = mahasiswaBaru.getProdi();

            if (prodiBaru != null) {
                mahasiswaToUpdate.setProdi(prodiBaru);

                db.commit();
            } else {
                System.out.println("Prodi pada data Mahasiswa baru tidak valid.");
            }
        } else {
            System.out.println("Mahasiswa dengan NIM " + nimLama + " tidak ditemukan.");
        }
    }


    public Mahasiswa getMahasiswaByNim(String nim) {
        for (Mahasiswa mahasiswa : db.getTables().dataMahasiswa) {
            if (mahasiswa.getNim().equals(nim)) {
                return mahasiswa;
            }
        }
        return null;
    }

    public void delete(String nim) {
        for (int i = 0; i < db.getTables().dataMahasiswa.size(); i++) {
            if (db.getTables().dataMahasiswa.get(i).getNim().equals(nim)) {
                db.getTables().dataMahasiswa.remove(i);
                break;
            }
        }
        db.commit();
    }

    public Prodi getProdiByID(String id) {
        for (Prodi prodi : db.getTables().dataProdi) {
            if (prodi.getId().equals(id)) {
                return prodi;
            }
        }
        return null;
    }
}
