package Tutorial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/*672115037 Phutawan Mueangma
ADT Tutorial 5 
 */

class Vaccine {
    private String name;
    private Date date;
    private String manufacturer;
    private String batch;

    public Vaccine(String name, Date date, String manufacturer, String batch) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Vaccine: " + name + ", Date: " + date + ", Manufacturer: " + manufacturer + ", Batch: " + batch;
    }
}

class CovidVaccine {
    private String SID;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String address;
    private List<Vaccine> vaccines;

    public CovidVaccine(String SID, String firstName, String lastName, String contact, String email, String address) {
        this.SID = SID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.vaccines = new ArrayList<>();
    }

    public CovidVaccine(String SID, String firstName, String lastName, String contact, String email, String address, List<Vaccine> vaccines) {
        this.SID = SID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.vaccines = vaccines;
    }

    public String getSID() {
        return SID;
    }

    public void addVaccine(Vaccine vaccine) {
        vaccines.add(vaccine);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(SID)
          .append(" Name: ").append(firstName).append(" ").append(lastName)
          .append(" Contact: ").append(contact)
          .append(" Email: ").append(email)
          .append(" Address: ").append(address);
        
        if (!vaccines.isEmpty()) {
            sb.append("\nVaccines: ");
            for (Vaccine v : vaccines) {
                sb.append("\n  - ").append(v.toString());
            }
        }

        sb.append("-->");
        
        return sb.toString();
    }
}

class VaccineLinkedList {
    private Node head;
    private int size;

    public VaccineLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(CovidVaccine data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void delete(String SID) {
        Node current = head;
        Node previous = null;
        
        while (current != null && !current.data.getSID().equals(SID)) { 
            previous = current;
            current = current.next;
        }

        if (current != null) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            size--;
        }
    }

    public void deleteAll() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void traversal() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private class Node {
        CovidVaccine data;
        Node next;

        Node(CovidVaccine data) {
            this.data = data;
            this.next = null;
        }
    }
}

public class VaccineManagementSystem {
    public static void main(String[] args) {
        VaccineLinkedList list = new VaccineLinkedList();
        Random random = new Random();
        
        List<Vaccine> vaccines1 = new ArrayList<>();
        vaccines1.add(new Vaccine("Pfizer", new Date(), "Pfizer Inc", "BATCH-121"));
        vaccines1.add(new Vaccine("Moderna", new Date(), "Moderna Inc", "BATCH-122"));
        CovidVaccine person1 = new CovidVaccine("SID001", "Phutawan", "Mueangma", "0841234567", "Phutawanmueangma@gmail.com", "Phingpayom, Chiang Mai", vaccines1);

        List<Vaccine> vaccines2 = new ArrayList<>();
        vaccines2.add(new Vaccine("Pfizer", new Date(), "Pfizer Inc", "BATCH-123"));
        CovidVaccine person2 = new CovidVaccine("SID002", "Ranticha", "Chumjai", "0614128402", "Ranticha@gmail.com", "567 Suthep, Chiang Mai", vaccines2);

        List<Vaccine> vaccines3 = new ArrayList<>();
        vaccines3.add(new Vaccine("Johnson & Johnson", new Date(), "Johnson & Johnson Inc", "BATCH-124"));
        CovidVaccine person3 = new CovidVaccine("SID003", "Nutthapat", "Jagkhuruang", "0851234568", "NutthapatMay@gmail.com", "678 Changklan, Chiang Mai", vaccines3);

        List<Vaccine> vaccines4 = new ArrayList<>();
        vaccines4.add(new Vaccine("AstraZeneca", new Date(), "AstraZeneca Inc", "BATCH-125"));
        vaccines4.add(new Vaccine("Moderna", new Date(), "Moderna Inc", "BATCH-122"));
        CovidVaccine person4 = new CovidVaccine("SID004", "Thinnaphob", "Srisomboon", "0841234557", "Thinnapho@gmail.com", "456 Thapae, Chiang Mai", vaccines4);

        List<Vaccine> vaccines5 = new ArrayList<>();
        vaccines5.add(new Vaccine("Pfizer", new Date(), "Pfizer Inc", "BATCH-123"));
        CovidVaccine person5 = new CovidVaccine("SID005", "Ratnicha", "jaiChum", "0614458402", "Ratnicha@gmail.com", "123 Nimman, Chiang Mai", vaccines5);

        List<Vaccine> vaccines6 = new ArrayList<>();
        vaccines6.add(new Vaccine("Pfizer", new Date(), "Pfizer Inc", "BATCH-123"));
        vaccines6.add(new Vaccine("AstraZeneca", new Date(), "AstraZeneca Inc", "BATCH-125"));
        CovidVaccine person6 = new CovidVaccine("SID006", "Guykung", "Kongthong", "0985612374", "Guykung888@gmail.com", "12 Moonmuang, Chiang Mai", vaccines6);

        List<Vaccine> vaccines7 = new ArrayList<>();
        vaccines7.add(new Vaccine("Moderna", new Date(), "Moderna Inc", "BATCH-122"));
        vaccines7.add(new Vaccine("AstraZeneca", new Date(), "AstraZeneca Inc", "BATCH-125"));
        CovidVaccine person7 = new CovidVaccine("SID007", "Meatavee", "Aenjang", "0841298757", "Meatavee@gmail.com", "321 Huaykaew Road, Chiang Mai", vaccines7);

        List<Vaccine> vaccines8 = new ArrayList<>();
        vaccines8.add(new Vaccine("Pfizer", new Date(), "Pfizer Inc", "BATCH-123"));
        CovidVaccine person8 = new CovidVaccine("SID008", "Narapath", "Leelasajjakul", "0123658974", "Narapath@gmail.com", "890 Nimmanhaemin, Chiang Mai", vaccines8);

        List<Vaccine> vaccines9 = new ArrayList<>();
        vaccines9.add(new Vaccine("Johnson & Johnson", new Date(), "Johnson & Johnson Inc", "BATCH-124"));
        CovidVaccine person9 = new CovidVaccine("SID009", "Ponkrit", "Saenglha", "0857864568", "BankPonkrit@gmail.com", "345 Huaykaew, Chiang Mai", vaccines9);

        List<Vaccine> vaccines10 = new ArrayList<>();
        vaccines10.add(new Vaccine("Moderna", new Date(), "Moderna Inc", "BATCH-122"));
        vaccines10.add(new Vaccine("AstraZeneca", new Date(), "AstraZeneca Inc", "BATCH-125"));
        CovidVaccine person10 = new CovidVaccine("SID010", "Tatt", "Putjorn", "0987421536", "Nanotatt@gmail.com", "789 Old City, Chiang Mai", vaccines10);

        list.insert(person1);
        list.insert(person2);
        list.insert(person3);
        list.insert(person4);
        list.insert(person5);
        list.insert(person6);
        list.insert(person7);
        list.insert(person8);
        list.insert(person9);
        list.insert(person10);
        
        System.out.println("Initial list of all applicants:");
        list.traversal();
        
        int firstDelete = random.nextInt(10) + 1; 
        int secondDelete = random.nextInt(10) + 11;
        
        System.out.println("\nDeleting two random applicants...");
        System.out.println("Deleting SID" + String.format("%03d", firstDelete));
        System.out.println("Deleting SID" + String.format("%03d", secondDelete));
        
        list.delete("SID" + String.format("%03d", firstDelete));
        list.delete("SID" + String.format("%03d", secondDelete));
        
        System.out.println("\nRemaining applicants after random deletion:");
        list.traversal();
        
        System.out.println("Deleting all applicants...");
        list.deleteAll();
        
        System.out.println("\nRemaining applicants after deleting all:");
        list.traversal();
        
        System.out.println("Is list empty? " + list.isEmpty());
        System.out.println("Final size: " + list.getSize());
    }
}