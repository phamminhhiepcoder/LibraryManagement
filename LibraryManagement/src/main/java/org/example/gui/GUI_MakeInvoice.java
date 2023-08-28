package org.example.gui;

import org.example.dao.BookDao;
import org.example.dao.CustomerDao;
import org.example.dao.InvoiceDao;
import org.example.dao.impl.BookDaoImpl;
import org.example.dao.impl.CustomerDaoImpl;
import org.example.dao.impl.InvoiceDaoImpl;
import org.example.entities.Book;
import org.example.entities.Customer;
import org.example.entities.Invoice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GUI_MakeInvoice extends JPanel implements ActionListener, MouseListener, KeyListener {
    private static final long serialVersionUID = 1L;
    private final JTextField txtPrice;
    private final JTextField txtBookId;
    private JTextField txtCustomerId;
    private JTextField txtCustomerName;
    private JTable tableChiTietHD;
    private JTable tableBook;
    private JTable tableCustomer;
    private DefaultTableModel tableModelBook;
    private JTextField txtMaKH;
    private JTextField txtHDCustomerName;
    private JTextField txtBookName;
    private JTextField txtBookCategory;
    private JButton btnAddBook;
    private JButton btnCheckout;
    private JLabel lblFee;
    private JTextField txtPurchasedDate;
    private CustomerDao customerDao;
    private BookDao bookDao;


    public GUI_MakeInvoice() {
        customerDao = new CustomerDaoImpl();
        bookDao = new BookDaoImpl();

        Font f = this.getFont();
        this.setFont(new Font(f.getName(), f.getStyle(), 14));
        this.setLayout(new GridLayout(1, 0, 0, 0));
        JPanel panelChooseInfo = new JPanel();
        this.add(panelChooseInfo);
        panelChooseInfo.setLayout(new BorderLayout(0, 0));
        JPanel panelChooseCustomer = new JPanel();
        panelChooseCustomer.setBorder(new TitledBorder((Border) null, "Chọn khách hàng", 4, 2, (Font) null, (Color) null));
        panelChooseInfo.add(panelChooseCustomer, "North");
        panelChooseCustomer.setLayout(new GridLayout(1, 2, 0, 0));
        JPanel panelInfoCustomer = new JPanel();
        panelInfoCustomer.setAlignmentX(0.0F);
        panelChooseCustomer.add(panelInfoCustomer);
        GridBagLayout gbl_panelInfoCustomer = new GridBagLayout();
        gbl_panelInfoCustomer.columnWidths = new int[]{117, 86, 0};
        gbl_panelInfoCustomer.rowHeights = new int[]{15, 15, 27, 0};
        gbl_panelInfoCustomer.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panelInfoCustomer.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelInfoCustomer.setLayout(gbl_panelInfoCustomer);
        JLabel lblId = new JLabel("Mã khách hàng: ");
        lblId.setFont(new Font("Dialog", 1, 12));
        lblId.setHorizontalAlignment(0);
        GridBagConstraints gbc_lblCustomerId = new GridBagConstraints();
        gbc_lblCustomerId.anchor = 18;
        gbc_lblCustomerId.insets = new Insets(0, 0, 5, 5);
        gbc_lblCustomerId.gridx = 0;
        gbc_lblCustomerId.gridy = 0;
        panelInfoCustomer.add(lblId, gbc_lblCustomerId);
        this.txtCustomerId = new JTextField();
        this.txtCustomerId.setEnabled(false);
        GridBagConstraints gbc_txtId = new GridBagConstraints();
        gbc_txtId.fill = 2;
        gbc_txtId.anchor = 11;
        gbc_txtId.insets = new Insets(0, 0, 5, 0);
        gbc_txtId.gridx = 1;
        gbc_txtId.gridy = 0;
        panelInfoCustomer.add(this.txtCustomerId, gbc_txtId);
        this.txtCustomerId.setColumns(10);

        JLabel lblCustomerName = new JLabel("Tên khách hàng: ");
        lblCustomerName.setFont(new Font("Dialog", 1, 12));
        lblCustomerName.setHorizontalAlignment(0);
        GridBagConstraints gbc_lblCustomerName = new GridBagConstraints();
        gbc_lblCustomerName.anchor = 18;
        gbc_lblCustomerName.insets = new Insets(0, 0, 5, 5);
        gbc_lblCustomerName.gridx = 0;
        gbc_lblCustomerName.gridy = 1;
        panelInfoCustomer.add(lblCustomerName, gbc_lblCustomerName);
        this.txtCustomerName = new JTextField();
        this.txtCustomerName.setEnabled(false);
        GridBagConstraints gbc_txtCustomerName = new GridBagConstraints();
        gbc_txtCustomerName.fill = 2;
        gbc_txtCustomerName.anchor = 11;
        gbc_txtCustomerName.insets = new Insets(0, 0, 5, 0);
        gbc_txtCustomerName.gridx = 1;
        gbc_txtCustomerName.gridy = 1;
        panelInfoCustomer.add(this.txtCustomerName, gbc_txtCustomerName);
        this.txtCustomerName.setColumns(10);

        String[] headerTableCustomer = new String[]{"Mã KH", "Tên KH"};
        DefaultTableModel tableModelCustomer = new DefaultTableModel(headerTableCustomer, 0) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPaneCustomer = new JScrollPane(this.tableCustomer = new JTable(tableModelCustomer));
        this.tableCustomer.setSelectionForeground(UIManager.getColor("Table.selectionInactiveForeground"));
        this.tableCustomer.setSelectionBackground(UIManager.getColor("Table.selectionInactiveBackground"));
        this.tableCustomer.getTableHeader().setFont(new Font(this.getName(), f.getStyle(), 13));
        this.tableCustomer.setFont(new Font(f.getName(), f.getStyle(), 14));
        this.tableCustomer.setRowHeight(24);
        scrollPaneCustomer.setPreferredSize(new Dimension(100, 100));
        panelChooseCustomer.add(scrollPaneCustomer);
        JPanel panelChooseBook = new JPanel();
        panelChooseBook.setBorder(new TitledBorder((Border) null, "Chọn sách", 4, 2, (Font) null, (Color) null));
        panelChooseInfo.add(panelChooseBook, "Center");
        panelChooseBook.setLayout(new BorderLayout(0, 0));
        JPanel panelChooseBookLeft = new JPanel();
        panelChooseBook.add(panelChooseBookLeft, "Center");
        panelChooseBookLeft.setLayout(new BorderLayout(0, 0));
        JPanel panelInfoBook = new JPanel();
        panelChooseBookLeft.add(panelInfoBook, "North");
        GridBagLayout gbl_panelInfoBook = new GridBagLayout();
        gbl_panelInfoBook.columnWidths = new int[]{85, 119, 0};
        gbl_panelInfoBook.rowHeights = new int[]{24, 24, 24, 24, 24, 0};
        gbl_panelInfoBook.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panelInfoBook.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelInfoBook.setLayout(gbl_panelInfoBook);

        JLabel lblBookName = new JLabel("Tên sách");
        lblBookName.setFont(new Font("Dialog", 1, 12));
        GridBagConstraints gbc_lblBookName = new GridBagConstraints();
        gbc_lblBookName.fill = 1;
        gbc_lblBookName.insets = new Insets(0, 0, 5, 5);
        gbc_lblBookName.gridx = 0;
        gbc_lblBookName.gridy = 0;
        panelInfoBook.add(lblBookName, gbc_lblBookName);
        this.txtBookName = new JTextField();
        GridBagConstraints gbc_txtBookName = new GridBagConstraints();
        gbc_txtBookName.fill = 1;
        gbc_txtBookName.insets = new Insets(0, 0, 5, 0);
        gbc_txtBookName.gridx = 1;
        gbc_txtBookName.gridy = 0;
        panelInfoBook.add(this.txtBookName, gbc_txtBookName);
        this.txtBookName.setColumns(10);

        JLabel lblBookId = new JLabel("ID");
        lblBookId.setFont(new Font("Dialog", 1, 12));
        GridBagConstraints gbc_lblBookId = new GridBagConstraints();
        gbc_lblBookId.fill = 1;
        gbc_lblBookId.insets = new Insets(0, 0, 5, 5);
        gbc_lblBookId.gridx = 0;
        gbc_lblBookId.gridy = 2;
        panelInfoBook.add(lblBookId, gbc_lblBookId);
        this.txtBookId = new JTextField();
        GridBagConstraints gbc_cbBookId = new GridBagConstraints();
        gbc_cbBookId.fill = 1;
        gbc_cbBookId.insets = new Insets(0, 0, 5, 0);
        gbc_cbBookId.gridx = 1;
        gbc_cbBookId.gridy = 2;
        panelInfoBook.add(this.txtBookId, gbc_cbBookId);

        JLabel lblPrice = new JLabel("Giá tiền");
        lblPrice.setFont(new Font("Dialog", 1, 12));
        GridBagConstraints gbc_lblPrice = new GridBagConstraints();
        gbc_lblPrice.fill = 1;
        gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrice.gridx = 0;
        gbc_lblPrice.gridy = 1;
        panelInfoBook.add(lblPrice, gbc_lblPrice);
        this.txtPrice = new JTextField();
        GridBagConstraints gbc_cbLoaiXe = new GridBagConstraints();
        gbc_cbLoaiXe.fill = 1;
        gbc_cbLoaiXe.insets = new Insets(0, 0, 5, 0);
        gbc_cbLoaiXe.gridx = 1;
        gbc_cbLoaiXe.gridy = 1;
        panelInfoBook.add(this.txtPrice, gbc_cbLoaiXe);

        JLabel lblCategory = new JLabel("Thể loại");
        lblCategory.setFont(new Font("Dialog", 1, 12));
        GridBagConstraints gbc_lblCategory = new GridBagConstraints();
        gbc_lblCategory.fill = 1;
        gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategory.gridx = 0;
        gbc_lblCategory.gridy = 3;
        panelInfoBook.add(lblCategory, gbc_lblCategory);
        this.txtBookCategory = new JTextField();
        GridBagConstraints gbc_tfCategory = new GridBagConstraints();
        gbc_tfCategory.fill = 1;
        gbc_tfCategory.insets = new Insets(0, 0, 5, 0);
        gbc_tfCategory.gridx = 1;
        gbc_tfCategory.gridy = 3;
        panelInfoBook.add(this.txtBookCategory, gbc_tfCategory);

        String[] headerTableBook = "Id;Tên sách;Thể loại;Số lượng trong kho;Giá tiền".split(";");
        this.tableModelBook = new DefaultTableModel(headerTableBook, 0);
        JScrollPane scrollPaneBook = new JScrollPane(this.tableBook = new JTable(this.tableModelBook));
        this.tableBook.setSelectionForeground(UIManager.getColor("Table.selectionInactiveForeground"));
        this.tableBook.setSelectionBackground(UIManager.getColor("Table.selectionInactiveBackground"));
        this.tableBook.getTableHeader().setFont(new Font(f.getName(), f.getStyle(), 13));
        this.tableBook.setFont(new Font(f.getName(), f.getStyle(), 14));
        this.tableBook.setRowHeight(24);
        panelChooseBookLeft.add(scrollPaneBook, "Center");
        JPanel panelChooseBookRight = new JPanel();
        panelChooseBook.add(panelChooseBookRight, "East");
        panelChooseBookRight.setLayout(new BorderLayout(0, 0));
        this.btnAddBook = new JButton("Thêm vào hóa đơn");
        this.btnAddBook.setFont(new Font("Dialog", 0, 14));
        panelChooseBookRight.add(this.btnAddBook, "South");
        this.btnAddBook.addActionListener(this);

        this.tableBook.addMouseListener(this);

        JPanel panelHD = new JPanel();
        this.add(panelHD);
        panelHD.setLayout(new BorderLayout(0, 0));
        JPanel panelChiTietHD = new JPanel();
        panelChiTietHD.setBorder(new TitledBorder((Border) null, "Chi tiết hóa đơn", 4, 2, (Font) null, (Color) null));
        panelHD.add(panelChiTietHD, "Center");
        panelChiTietHD.setLayout(new BorderLayout(0, 0));
        JPanel panelInfoHD = new JPanel();
        panelChiTietHD.add(panelInfoHD, "North");
        GridBagLayout gbl_panelInfoHD = new GridBagLayout();
        gbl_panelInfoHD.columnWidths = new int[]{137, 200, 0};
        gbl_panelInfoHD.rowHeights = new int[]{19, 19, 19, 0};
        gbl_panelInfoHD.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panelInfoHD.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelInfoHD.setLayout(gbl_panelInfoHD);
        JLabel lblMaKH = new JLabel("Mã khách hàng");
        lblMaKH.setFont(new Font("Dialog", 1, 12));
        GridBagConstraints gbc_lblMaKH = new GridBagConstraints();
        gbc_lblMaKH.fill = 1;
        gbc_lblMaKH.insets = new Insets(0, 0, 5, 5);
        gbc_lblMaKH.gridx = 0;
        gbc_lblMaKH.gridy = 0;
        panelInfoHD.add(lblMaKH, gbc_lblMaKH);
        this.txtMaKH = new JTextField();
        GridBagConstraints gbc_txtMaKH = new GridBagConstraints();
        gbc_txtMaKH.fill = 1;
        gbc_txtMaKH.insets = new Insets(0, 0, 5, 0);
        gbc_txtMaKH.gridx = 1;
        gbc_txtMaKH.gridy = 0;
        panelInfoHD.add(this.txtMaKH, gbc_txtMaKH);
        this.txtMaKH.setColumns(10);
        JLabel lblHDTenNCC = new JLabel("Tên khách hàng");
        lblHDTenNCC.setFont(new Font("Dialog", 1, 12));
        GridBagConstraints gbc_lblHDTenNCC = new GridBagConstraints();
        gbc_lblHDTenNCC.fill = 1;
        gbc_lblHDTenNCC.insets = new Insets(0, 0, 5, 5);
        gbc_lblHDTenNCC.gridx = 0;
        gbc_lblHDTenNCC.gridy = 1;
        panelInfoHD.add(lblHDTenNCC, gbc_lblHDTenNCC);
        this.txtHDCustomerName = new JTextField();
        GridBagConstraints gbc_txtHDTenNCC = new GridBagConstraints();
        gbc_txtHDTenNCC.fill = 1;
        gbc_txtHDTenNCC.insets = new Insets(0, 0, 5, 0);
        gbc_txtHDTenNCC.gridx = 1;
        gbc_txtHDTenNCC.gridy = 1;
        panelInfoHD.add(this.txtHDCustomerName, gbc_txtHDTenNCC);
        this.txtHDCustomerName.setColumns(10);

        JLabel lblNgayDatHang = new JLabel("Ngày đặt hàng");
        lblNgayDatHang.setFont(new Font("Dialog", 1, 12));
        GridBagConstraints gbc_lblNgayDatHang = new GridBagConstraints();
        gbc_lblNgayDatHang.fill = 1;
        gbc_lblNgayDatHang.insets = new Insets(0, 0, 0, 5);
        gbc_lblNgayDatHang.gridx = 0;
        gbc_lblNgayDatHang.gridy = 2;
        panelInfoHD.add(lblNgayDatHang, gbc_lblNgayDatHang);
        this.txtPurchasedDate = new JTextField();
        GridBagConstraints gbc_txtNgayDatHang = new GridBagConstraints();
        gbc_txtNgayDatHang.fill = 1;
        gbc_txtNgayDatHang.gridx = 1;
        gbc_txtNgayDatHang.gridy = 2;
        panelInfoHD.add(this.txtPurchasedDate, gbc_txtNgayDatHang);
        this.txtPurchasedDate.setColumns(10);
        JPanel panelThanhTien = new JPanel();
        FlowLayout fl_panelThanhTien = (FlowLayout) panelThanhTien.getLayout();
        fl_panelThanhTien.setHgap(100);
        panelChiTietHD.add(panelThanhTien, "South");
        JLabel lblThanhTien = new JLabel("Thành tiền");
        lblThanhTien.setFont(new Font("Dialog", 1, 12));
        panelThanhTien.add(lblThanhTien);
        this.lblFee = new JLabel("0 VND");
        panelThanhTien.add(this.lblFee);
        String[] headerCTHD = "STT;Mã sách;Tên sách;Đơn giá".split(";");
        DefaultTableModel tableModelCTHD = new DefaultTableModel(headerCTHD, 0);
        JScrollPane scrollPaneCTHD = new JScrollPane(this.tableChiTietHD = new JTable(tableModelCTHD));
        this.tableChiTietHD.setSelectionForeground(UIManager.getColor("Table.selectionInactiveForeground"));
        this.tableChiTietHD.setSelectionBackground(UIManager.getColor("Table.selectionInactiveBackground"));
        this.tableChiTietHD.getTableHeader().setFont(new Font(f.getName(), f.getStyle(), 13));
        this.tableChiTietHD.setFont(new Font(f.getName(), f.getStyle(), 14));
        this.tableChiTietHD.setRowHeight(24);
        panelChiTietHD.add(scrollPaneCTHD, "Center");
        JPanel panelNhapHang = new JPanel();
        panelHD.add(panelNhapHang, "South");
        this.btnCheckout = new JButton("Checkout");
        this.btnCheckout.setFont(new Font("Dialog", 0, 14));
        btnCheckout.addActionListener(this);
        panelNhapHang.add(this.btnCheckout);
        this.loadCustomerList();
        this.loadBookList();
        this.tableCustomer.addMouseListener(this);
        this.tableBook.addMouseListener(this);
    }

    private void loadBookList() {
        List<Book> books = bookDao.getAll();
        this.bookDao.getAll().forEach((book) -> {
            this.tableModelBook.addRow(new Object[]{book.getId(), book.getName(), book.getCategory(), book.getQuantity(), book.getPrice()});
        });
    }

    public void loadCustomerList() {
        DefaultTableModel tableModel = (DefaultTableModel) this.tableCustomer.getModel();
        tableModel.setRowCount(0);
        List<Customer> customers = this.customerDao.getAll();
        if (!customers.isEmpty()) {
            Iterator iterator = customers.iterator();

            while (iterator.hasNext()) {
                Customer customer = (Customer) iterator.next();
                Integer customerId = customer.getId();
                String customerName = customer.getFullName();
                tableModel.addRow(new Object[]{customerId, customerName});
            }
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        Object o = e.getSource();
        int rowSl;
        if (o.equals(this.tableCustomer)) {
            rowSl = this.tableCustomer.getSelectedRow();
            this.txtCustomerId.setText(this.tableCustomer.getValueAt(rowSl, 0).toString());
            this.txtCustomerName.setText(this.tableCustomer.getValueAt(rowSl, 1).toString());
        }

        if (o.equals(this.tableCustomer)) {
            rowSl = this.tableCustomer.getSelectedRow();
            this.txtCustomerId.setText(this.tableCustomer.getValueAt(rowSl, 0).toString());
            this.txtCustomerName.setText(this.tableCustomer.getValueAt(rowSl, 1).toString());
        }
        if (o.equals(this.tableBook)) {
            int selectedRow = this.tableBook.getSelectedRow();

            if (selectedRow != -1) {
                Integer bookId = Integer.parseInt(this.tableModelBook.getValueAt(selectedRow, 0).toString());
                String bookName = (String) this.tableModelBook.getValueAt(selectedRow, 1);
                String bookCategory = (String) this.tableModelBook.getValueAt(selectedRow, 2);
                Float bookPrice = Float.parseFloat(this.tableModelBook.getValueAt(selectedRow, 4).toString());

                this.txtBookId.setText(bookId + "");
                this.txtBookName.setText(bookName);
                this.txtBookCategory.setText(bookCategory);
                this.txtPrice.setText(bookPrice + "");
            }
        }
    }


    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static float amount = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAddBook)) {
            if(txtMaKH.getText() != txtCustomerId.getText()){
                txtMaKH.setText(txtCustomerId.getText());
                txtHDCustomerName.setText(txtCustomerName.getText());
                txtPurchasedDate.setText(LocalDateTime.now().toString());
            }
            Integer bookId = Integer.parseInt(txtBookId.getText());
            String bookName = txtBookName.getText();
            String bookCategory = txtBookCategory.getText();
            Book book = bookDao.findByName(bookName);
            Float price = book.getPrice();

            if (bookName.isEmpty() || bookCategory.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            amount += price;
            DefaultTableModel tableModelCTHD = (DefaultTableModel) tableChiTietHD.getModel();
            tableModelCTHD.addRow(new Object[]{tableModelCTHD.getRowCount() + 1, bookId, bookName, price});
            lblFee.setText(amount + "");

            txtBookId.setText("");
            txtBookName.setText("");
            txtBookCategory.setText("");
            txtPrice.setText("");
            txtCustomerId.setText("");
            txtCustomerName.setText("");
        }

        if (e.getSource().equals(btnCheckout)) {
            try {
                String customerName = txtHDCustomerName.getText();
                String purchasedDateStr = txtPurchasedDate.getText();
                Integer id = Integer.parseInt(txtMaKH.getText());
                if (customerName.isEmpty() || purchasedDateStr.isEmpty() || txtMaKH.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Invoice invoice = new Invoice();
                Customer customer = customerDao.getOne(id);
                List<Book> books = new ArrayList<>();
                DefaultTableModel tableModelCTHD = (DefaultTableModel) tableChiTietHD.getModel();
                for (int row = 0; row < tableModelCTHD.getRowCount(); row++) {
                    Integer bookId = Integer.parseInt(tableModelCTHD.getValueAt(row, 1).toString());
                    Book book = bookDao.getOne(bookId);
                    book.setQuantity(book.getQuantity() - 1);
                    books.add(book);
                }
                invoice.setBooks(books);
                invoice.setCustomer(customer);
                invoice.setAmount(amount);
                invoice.setCreatedDate(LocalDateTime.now());
                invoice.setUpdatedDate(LocalDateTime.now());
                InvoiceDao invoiceDao = new InvoiceDaoImpl();
                invoiceDao.save(invoice);
                JOptionPane.showMessageDialog(this, "Invoice saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                amount = 0;
                txtMaKH.setText("");
                txtHDCustomerName.setText("");
                txtPurchasedDate.setText("");
                tableModelCTHD.setRowCount(0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
