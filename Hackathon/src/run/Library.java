package run;

import config.Config;
import controller.BookController;
import model.Book;

public class Library {
    private static BookController bookController = new BookController();

    public static void menuBook() {
        int choice = 0;
        while (choice != 5) {

            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1.  Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần ");
            System.out.println("4. Xóa sách theo mã sách ");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả ");
            System.out.println("6. Thay đổi thông tin sách theo mã sách ");
            System.out.println("7. Thoát");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // thêm mới
                    addNewBook();

                    break;
                case 2:
                    // hiển thị danh sách sách
                    displayBook();
                    break;
                case 3:
                    break;
                case 4:
                    // xóa
                    deleteBook();
                    break;
                case 5:
                    break;

                case 6:  // update
                    updateBook();
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }

    public static void displayBook() {
        if (bookController.getSize() == 0) {
            System.err.println("khong co sach trong thu vien");
            return;
        }
        for (Book book : bookController.getAll()) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }

    // them moi sach
    public static void addNewBook() {
        if (bookController.getSize() == 0) {
            System.err.println("Bạn phải thêm danh mục trước");
            return;
        }
        System.out.println("nhập số lượng sach cần thêm mới");
        int n = Config.scanner().nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập thông tin sach thứ " + (i + 1));
            Book newBook = new Book();
            int id = bookController.getNewId();
            System.out.println("Id : " + id);
            newBook.setId(id);
            System.out.println("nhập tên sach");
            newBook.setName(Config.scanner().nextLine());
            // cho phép chọn danh mục cho sách
            displayAll();
            // chọn theo id của danh mục
            while (true) {
                System.out.println("Nhập id cua danh mục");
                int categoryId = Config.scanner().nextInt();
                Book cat = bookController.findById(categoryId);
                if (cat == null) {
                    System.err.println("Id không tôn tại, vui lòng nhập lại");
                } else {
                    newBook.setCategory(cat);
                    break;
                }
            }
            System.out.println("nhập giá");
            newBook.setPrice(Config.scanner().nextDouble());
            System.out.println("nhập tên tác giả");
            newBook.setAuthorName(Config.scanner().nextLine());
            System.out.println("nhập số lương");
            newBook.setQuantity(Config.scanner().nextInt());
            System.out.println("nhập tổng số trang");
            newBook.setTotalPage(Config.scanner().nextInt());
            // lưu nó vào listBook
            bookController.save(newBook);

        }
    }

    public static void updateBook() {
        System.out.println("Nhập vào id cần sửa");
        int id = Config.scanner().nextInt();
        Book bookEdit = bookController.findById(id);
        if (bookEdit == null) {
            System.err.println("id không tồn tại ");
            return;
        }
        // cho phép người dùng sửa
        System.out.println("nhập tên sach moi");
        bookEdit.setName(Config.scanner().nextLine());
        // cho phép chọn danh mục cho sách

        // chọn theo id của danh mục
        while (true) {
            System.out.println("Nhập id cua danh mục moi");
            int categoryId = Config.scanner().nextInt();
            Category cat = categoryController.findById(categoryId);
            if (cat == null) {
                System.err.println("Id không tôn tại, vui lòng nhập lại");
            } else {
                bookEdit.setCategory(cat);
                break;
            }
        }
        System.out.println("nhập giá moi");
        bookEdit.setPrice(Config.scanner().nextDouble());
        System.out.println("nhập tên tác giả moi");
        bookEdit.setAuthorName(Config.scanner().nextLine());
        System.out.println("nhập số lương moi");
        bookEdit.setQuantity(Config.scanner().nextInt());
        System.out.println("nhập tổng số trang moi");
        bookEdit.setTotalPage(Config.scanner().nextInt());
        // lưu thay đổi
        bookController.save(bookEdit);
    }

    /// xóa
    public static void deleteBook() {
        System.out.println(" hãy nhập vào id của sach muốn xóa");
        int idDel = Config.scanner().nextInt();
        // cho phép xóa
        bookController.delete(idDel);
    }
}
