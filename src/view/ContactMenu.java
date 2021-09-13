package view;

import controller.ContactManagement;
import controller.IContactManagement;
import model.Contact;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static ContactManagement contactManagement = new ContactManagement();

    public  void run() {
        int choice;
        {
            do {

                menu();
                choice = scanner.nextInt();
                switch (choice)
                {
                    case 1:
                    {
                        contactManagement.showAll();
                        break;
                    }
                    case 2:
                    {
                        addNewContact();
                        break;
                    }
                    case 3: {
                        updateNewContact();
                        break;
                    }
                    case 4:
                    {
                        deleteNumberPhone();
                        break;
                    }
                    case 5:
                    {
                        findContactByPhoneNumber();
                        break;
                    }
                    case 6: {
                        contactManagement.readFile("src/contact1");
                        break;
                    }
                    case 7:
                    {
                        contactManagement.writeFile("src/contact1");
                        break;
                    }
                }
            } while (choice != 0);
        }
    }
    public void findContactByPhoneNumber() {
        scanner.nextLine();
        System.out.println("nhập số điện thoại cần tìm");
        String phonenumber= scanner.nextLine();
        contactManagement.searchContactByPhoneNumber(phonenumber);
    }
    private static Contact initContact()
    {
        scanner.nextLine();
        Matcher matcher3;
        String numberPhone;
        do {
            System.out.println("Nhập số điện thoại");
            numberPhone = scanner.nextLine();
            String regex = "^[0-9]{2}-0[1-9][0-9]{8}$";
            Pattern pattern = Pattern.compile(regex);
            matcher3 = pattern.matcher(numberPhone);
            if (!matcher3.matches()) {
                System.err.println("Sai mã vùng hoặc số điện thoại");
            }
        } while (!matcher3.matches());
        System.out.println("nhóm của danh bạ");
        String group=scanner.nextLine();
        System.out.println("Họ tên");
        String name=scanner.nextLine();
        System.out.println("nhập giới tính");
        String sex=scanner.nextLine();
        System.out.println("nhập địa chỉ");
        String address= scanner.nextLine();
        System.out.println("nhập ngày sinh");
        String dateOfBirth= scanner.nextLine();
        Matcher matcher2;
        String email;
        do {
            System.out.println("Nhập Email");
            email = scanner.nextLine();
            String regex = "^[A-Za-z0-9_]{4,}@[A-Za-z]mail.com$";
            Pattern pattern = Pattern.compile(regex);
            matcher2 = pattern.matcher(email);
            if (!matcher2.matches()) {
                System.err.println("Mail không hợp lệ");
            }
        } while (!matcher2.matches());

        return new Contact(numberPhone,group,name,sex,address,dateOfBirth,email);
    }
    private void addNewContact() {
        Contact contact = initContact();
        contactManagement.addNew(contact);
    }
    private int getIndexFromNumberPhone() {
        System.out.println("Nhập số điện thoại : ");
        String numberPhone = scanner.nextLine();
        return contactManagement.findById(numberPhone);
    }
    private void deleteNumberPhone() {
        int index = getIndexFromNumberPhone();
        if (index == -1) {
            System.out.println("KHÔNG THẤY SỐ ĐIỆN THOẠI NÀY TRONG DANH BẠ");
        } else {
            int choice1;
            do{
                choice1=scanner.nextInt();
                menuDelete();
            } while(choice1 !=1 || choice1 !=2);
        }
    }

    private void menuDelete() {
        System.out.println("XÓA SỐ ĐIỆN THOẠI");
        System.out.println("1.XÓA");
        System.out.println("2.QUAY LẠI");
    }
    private void updateNewContact()
    {
        System.out.println("nhập id cần sửa");
        String index= scanner.nextLine();
        if (index.equals(-1) ) {
            System.out.println("KHÔNG THẤY SỐ ĐIỆN THOẠI NÀY TRONG DANH BẠ");
        } else {
            System.out.println("SỬA THÔNG TIN THUÊ BAO");
            Contact contact = initContact();
            contactManagement.updateById(index, contact);
            System.out.println("CẬP NHẬP THÀNH CÔNG");

        }
    }
    private static void menu(){
            System.out.println("========Quản lí danh bạ========");
            System.out.println("Chọn chức năng theo số(để tiếp tục):");
            System.out.println("1.Hiển thị danh bạ");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi vào file");
            System.out.println("Chọn chức năng");
        }
    }
