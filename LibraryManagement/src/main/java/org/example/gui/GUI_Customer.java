package org.example.gui;

import org.example.dao.BookDao;
import org.example.dao.impl.BookDaoImpl;
import org.example.entities.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GUI_Customer extends JPanel implements ActionListener, MouseListener {

	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtId;
    private JTextField txtISBN;
	private JTextField txtName;
	private JTextField txtAuthorName;
	private JTextField txtLanguage;
    private JTextField txtQuantity;
    private JTextField txtPrice;
    private JTextField txtCategory;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnReload;
	private JButton btnFilter;
    private final BookDao bookDao;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public GUI_Customer() {

//		try {
//			ConnectDB.getInstance().connect();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		xeMay_DAO = new XeMay_DAO();
//		loaiXe_DAO = new LoaiXe_DAO();
//		nhaCC_DAO = new NhaCungCap_DAO();
        bookDao = new BookDaoImpl();

		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel pThongTinSach = new JPanel();
		pThongTinSach.setBackground(new Color(255, 255, 255));
		pThongTinSach.setBounds(0, 0, 1180, 305);
		add(pThongTinSach);
		pThongTinSach.setLayout(null);
		pThongTinSach.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin xe máy"));

		JPanel pMaSach = new JPanel();
		pMaSach.setBackground(new Color(255, 255, 255));
		pMaSach.setBounds(20, 21, 383, 45);
		pThongTinSach.add(pMaSach);
		pMaSach.setLayout(null);
		JLabel lblNewLabel = new JLabel("Mã sách: ");
		lblNewLabel.setBounds(0, 12, 80, 14);
		pMaSach.add(lblNewLabel);
		txtId = new JTextField();
		txtId.setBounds(106, 5, 260, 29);
		pMaSach.add(txtId);
		txtId.setColumns(10);

		JPanel pTenSach = new JPanel();
		pTenSach.setBackground(new Color(255, 255, 255));
		pTenSach.setLayout(null);
		pTenSach.setBounds(20, 105, 383, 45);
		pThongTinSach.add(pTenSach);
		JLabel lblNewLabel_1 = new JLabel("Tên sách:");
		lblNewLabel_1.setBounds(0, 12, 82, 14);
		pTenSach.add(lblNewLabel_1);
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(106, 5, 260, 29);
		pTenSach.add(txtName);

		JPanel pISBN = new JPanel();
		pISBN.setBackground(new Color(255, 255, 255));
		pISBN.setLayout(null);
		pISBN.setBounds(20, 62, 383, 45);
		pThongTinSach.add(pISBN);
		JLabel lbISBN = new JLabel("ISBN:");
		lbISBN.setBounds(0, 12, 78, 14);
		pISBN.add(lbISBN);
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(106, 5, 260, 29);
		pISBN.add(txtISBN);

		JPanel pNgonNgu = new JPanel();
		pNgonNgu.setBackground(new Color(255, 255, 255));
		pNgonNgu.setLayout(null);
		pNgonNgu.setBounds(20, 194, 383, 45);
		pThongTinSach.add(pNgonNgu);
		JLabel lblNgonNgu = new JLabel("Ngôn ngữ:");
		lblNgonNgu.setBounds(0, 12, 90, 14);
		pNgonNgu.add(lblNgonNgu);
		txtLanguage = new JTextField();
		txtLanguage.setColumns(10);
		txtLanguage.setBounds(106, 5, 260, 29);
		pNgonNgu.add(txtLanguage);

		JPanel pTacGia = new JPanel();
		pTacGia.setBackground(new Color(255, 255, 255));
		pTacGia.setLayout(null);
		pTacGia.setBounds(413, 21, 352, 45);
		pThongTinSach.add(pTacGia);
		JLabel lblTacGia = new JLabel("Tác giả:");
		lblTacGia.setBounds(0, 12, 80, 14);
		pTacGia.add(lblTacGia);
		txtAuthorName = new JTextField();
		txtAuthorName.setColumns(10);
		txtAuthorName.setBounds(84, 8, 268, 26);
		pTacGia.add(txtAuthorName);

		JPanel pTheLoai = new JPanel();
		pTheLoai.setBackground(new Color(255, 255, 255));
		pTheLoai.setLayout(null);
		pTheLoai.setBounds(413, 62, 352, 45);
		pThongTinSach.add(pTheLoai);
		JLabel lblTheLoai = new JLabel("Thể loại:");
		lblTheLoai.setBounds(0, 12, 74, 14);
		pTheLoai.add(lblTheLoai);
		txtCategory = new JTextField();
		txtCategory.setColumns(10);
		txtCategory.setBounds(84, 8, 268, 26);
		pTheLoai.add(txtCategory);

		JPanel pGia = new JPanel();
		pGia.setBackground(new Color(255, 255, 255));
		pGia.setLayout(null);
		pGia.setBounds(413, 105, 352, 45);
		pThongTinSach.add(pGia);
		JLabel lblNewLabel_6 = new JLabel("Giá:");
		lblNewLabel_6.setBounds(0, 12, 74, 14);
		pGia.add(lblNewLabel_6);
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(84, 5, 268, 29);
		pGia.add(txtPrice);

		JPanel pNamSanXuat = new JPanel();
		pNamSanXuat.setBackground(new Color(255, 255, 255));
		pNamSanXuat.setLayout(null);
		pNamSanXuat.setBounds(413, 149, 352, 45);
		pThongTinSach.add(pNamSanXuat);
		JLabel lblNewLabel_7 = new JLabel("Năm sản xuất:");
		lblNewLabel_7.setBounds(0, 12, 84, 14);
		pNamSanXuat.add(lblNewLabel_7);
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(84, 5, 268, 29);
		pNamSanXuat.add(txtISBN);

		Image imgThem = new ImageIcon("data//them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnAdd = new JButton("Thêm");
		btnAdd.setIcon(new ImageIcon(imgThem));
		btnAdd.setBackground(new Color(75, 209, 254));
		btnAdd.setForeground(new Color(128, 0, 0));
		btnAdd.setBounds(20, 256, 98, 37);
		pThongTinSach.add(btnAdd);

		btnDelete = new JButton("Xóa");
		btnDelete.setIcon(new ImageIcon("data//xoa.png"));
		btnDelete.setForeground(new Color(128, 0, 0));
		btnDelete.setBackground(new Color(75, 209, 254));
		btnDelete.setBounds(128, 256, 98, 37);
		pThongTinSach.add(btnDelete);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setIcon(new ImageIcon("data//sua.png"));
		btnUpdate.setForeground(new Color(128, 0, 0));
		btnUpdate.setBackground(new Color(75, 209, 254));
		btnUpdate.setBounds(236, 256, 98, 37);
		pThongTinSach.add(btnUpdate);

		btnReload = new JButton("Làm mới");
		btnReload.setIcon(new ImageIcon("data//lamMoi.png"));
		btnReload.setForeground(new Color(128, 0, 0));
		btnReload.setBackground(new Color(75, 209, 254));
		btnReload.setBounds(345, 256, 122, 37);
		pThongTinSach.add(btnReload);

		btnFilter = new JButton("Lọc");
		btnFilter.setIcon(new ImageIcon("data//filter.png"));
		btnFilter.setForeground(new Color(128, 0, 0));
		btnFilter.setBackground(new Color(75, 209, 254));
		btnFilter.setBounds(480, 256, 98, 37);
		pThongTinSach.add(btnFilter);

		Box bTable = Box.createVerticalBox();
		bTable.setBounds(0, 305, 1180, 294);
		add(bTable);
		bTable.add(Box.createRigidArea(new Dimension(0, 5)));
		String head[] = { "Mã sách", "ISBN", "Tên sách", "Ngôn ngữ", "Thể loại", "Số lượng", "Giá sách"
				};
		tableModel = new DefaultTableModel(head, 0);
		table = new JTable(tableModel);
		table.setBackground(new Color(255, 255, 255));
		bTable.add(new JScrollPane(table));

		List<Book> books = bookDao.getAll();
		readBooksToTable(books);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(810, 21, 345, 246);
		pThongTinSach.add(panel_2);

		JPanel pNhaCC = new JPanel();
		pNhaCC.setLayout(null);
		pNhaCC.setBackground(Color.WHITE);
		pNhaCC.setBounds(20, 149, 383, 45);
		pThongTinSach.add(pNhaCC);

		JLabel lblNewLabel_3_1 = new JLabel("Tên nhà cung cấp:");
		lblNewLabel_3_1.setBounds(0, 12, 106, 14);
		pNhaCC.add(lblNewLabel_3_1);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(106, 5, 260, 29);
		pNhaCC.add(txtQuantity);

		JPanel pCategory = new JPanel();
		pCategory.setLayout(null);
		pCategory.setBackground(Color.WHITE);
		pCategory.setBounds(413, 194, 352, 45);
		pThongTinSach.add(pCategory);

		JLabel lblCategory = new JLabel("Thể loại:");
		lblCategory.setBounds(0, 12, 90, 14);
		pCategory.add(lblCategory);

		txtCategory = new JTextField();
		txtCategory.setColumns(10);
		txtCategory.setBounds(85, 5, 267, 29);
		pCategory.add(txtCategory);

		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(596, 253, 292, 38);
		pThongTinSach.add(lblError);


		btnReload.addActionListener(this);
		btnFilter.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);

		table.addMouseListener(this);

	}

	public void createIconImage(JLabel x, int W, int H, String path) {
		ImageIcon image = new ImageIcon(
				new ImageIcon(path).getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH));
		x.setIcon(image);
		repaint();
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			addBook();
		}
		if (o.equals(btnDelete)) {
			deleteBook();
		}
		if (o.equals(btnUpdate)) {
			updateBook();
		}
		if (o.equals(btnReload)) {
			lamMoi();
		}
		if (o.equals(btnFilter)) {
			filterBook();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtId.setText(tableModel.getValueAt(row, 0).toString());
		txtLanguage.setText(tableModel.getValueAt(row, 1).toString());
		txtName.setText(tableModel.getValueAt(row, 2).toString());
		txtPrice.setText(tableModel.getValueAt(row, 5).toString());
		txtQuantity.setText(tableModel.getValueAt(row, 6).toString());
		txtAuthorName.setText(tableModel.getValueAt(row, 7).toString());
		txtISBN.setText(tableModel.getValueAt(row, 8).toString());
		txtCategory.setText(tableModel.getValueAt(row, 9).toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void readBooksToTable(List<Book> books) {
		DecimalFormat df = new DecimalFormat("0.##");
		for (Book book : books) {
			tableModel.addRow(new Object[] { book.getId(), book.getISBN(), book.getName(),
					book.getAuthorName(), book.getLanguage(),  book.getCategory(),
					book.getQuantity(), df.format(book.getPrice())});
		}
	}

	private void lamMoi() {
		txtPrice.setText("");
		txtISBN.setText("");
		txtQuantity.setText("");
		txtAuthorName.setText("");
		txtId.setText("");
		txtLanguage.setText("");
		txtName.setText("");
		txtCategory.setText("");
		lblError.setText("");
		List<Book> books = bookDao.getAll();
		xoaDuLieuTrongTable();
		readBooksToTable(books);
	}

	private void xoaDuLieuTrongTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

	private void addBook() {
		String ISBN = txtISBN.getText();
		if (!validateISBN(ISBN))
			return;
		if(!kiemTraRong())return ;
		String name = txtName.getText();
		String authorName = txtAuthorName.getText();
		String language = txtLanguage.getText();
		String category = txtCategory.getText();
		Integer quantity = Integer.parseInt(txtQuantity.getText());
		Float price = Float.parseFloat(txtPrice.getText());
		LocalDateTime createdDate = LocalDateTime.now();
		LocalDateTime updatedDate = LocalDateTime.now();

		if (checkIfExistName(name) && checkIfExistISBN(ISBN) && validateISBN(ISBN)) {
			Book book = new Book(ISBN, name, authorName, language, category, quantity, price, createdDate, updatedDate);
			bookDao.save(book);
			List<Book> books = bookDao.getAll();
			xoaDuLieuTrongTable();
			readBooksToTable(books);
		}
	}

	private boolean kiemTraChonHangTable(int row) {
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng dòng trên table");
			return false;
		} else {
			return true;
		}
	}

	private void deleteBook() {
		int row = table.getSelectedRow();
		if (kiemTraChonHangTable(row)) {
			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?");
			if (result == JOptionPane.NO_OPTION) {
				lamMoi();
				return;
			} else if (result == JOptionPane.CANCEL_OPTION) {
				return;
			} else {
				Integer id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
				bookDao.delete(id);
				xoaDuLieuTrongTable();
				List<Book> books = bookDao.getAll();
				readBooksToTable(books);
			}
		}
	}

	private void updateBook() {
		int row = table.getSelectedRow();
		if (kiemTraChonHangTable(row)) {
			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không?");
			if (result == JOptionPane.NO_OPTION) {
				lamMoi();
				return;
			} else if (result == JOptionPane.CANCEL_OPTION) {
				return;
			} else {
				Integer id = Integer.parseInt(txtId.getText());
				String ISBN = txtISBN.getText();
				String name = txtName.getText();
				String authorName = txtAuthorName.getText();
				String language = txtLanguage.getText();
				String category = txtCategory.getText();
				Integer quantity = Integer.parseInt(txtQuantity.getText());
				Float price = Float.parseFloat(txtPrice.getText());
				LocalDateTime updatedDate = LocalDateTime.now();
				Book book = new Book(id, ISBN, name, authorName, language, category, quantity, price, updatedDate);
				bookDao.update(book);
				List<Book> books = bookDao.getAll();
				xoaDuLieuTrongTable();
				readBooksToTable(books);
			}
		}
	}

	private boolean checkIfExistName(String name) {
		List<Book> books = bookDao.getAll();
		for (Book book : books) {
			if (name.trim().equals(book.getName())) {
				return false;
			}
		}
		return true;
	}

	private boolean checkIfExistISBN(String ISBN) {
		List<Book> books = bookDao.getAll();
		for (Book book : books) {
			if (ISBN.trim().equals(book.getISBN())) {
				return false;
			}
		}
		return true;
	}

	private boolean validateISBN(String ISBN) {
		if (ISBN.equals("")) {
			JOptionPane.showMessageDialog(this, "ISBN không được rỗng!");
			txtISBN.selectAll();
			txtISBN.requestFocus();
			return false;
		}
		String regex = "(([0-9A-Z]){4,5}-([0-9A-Z]){6,12})";
		if (!ISBN.matches(regex)) {
			JOptionPane.showMessageDialog(this,
					"Số khung có chiều dài từ 10-17 ký tự và có dạng XXXX-XXXXXX.. trong đó X là các kí tự số hoặc chữ hoa. Ví dụ: 082U-12H1268712");
			txtISBN.selectAll();
			txtISBN.requestFocus();
			return false;
		} else {
			return true;
		}
	}

	private List<Book> getBookListFromTable() {
		List<Book> books = new ArrayList<>();
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			Integer id = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
			String ISBN = tableModel.getValueAt(i, 1).toString();
			String name = tableModel.getValueAt(i, 2).toString();
			String authorName = tableModel.getValueAt(i, 3).toString();
			String language = tableModel.getValueAt(i, 4).toString();
			String category = tableModel.getValueAt(i, 5).toString();
			Integer quantity = Integer.parseInt(tableModel.getValueAt(i, 6).toString());
			Float price = Float.parseFloat(tableModel.getValueAt(i, 7).toString());

			Book book = new Book(id, ISBN, name, authorName, language, category, quantity, price);
			books.add(book);
		}
		return books;
	}

	private void filterBook() {
		int result = JOptionPane.showConfirmDialog(this, "Bạn đã làm mới trang trước khi chọn lọc chưa?", "Xác nhận",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.NO_OPTION) {
			return;
		} else {
			if(!txtCategory.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Không thể tìm sách theo ảnh");
				txtCategory.selectAll();
				txtCategory.requestFocus();
				return;
			}
			xoaDuLieuTrongTable();
			List<Book> ds = bookDao.getAll();
			readBooksToTable(ds);
			filterByISBN();
			filterByName();
			filterByLanguage();
			filterByAuthorName();
			filterByCategory();
			filterByPrice();
			List<Book> books = getBookListFromTable();
			if(books.size()<=0) {
				lblError.setText("Không tìm thấy dữ liệu bạn tìm kiếm!!");
			}else lblError.setText("Tìm thấy!");
		}
	}

	private void filterByISBN() {
		String ISBN = txtISBN.getText();
		if (ISBN.trim().equals("")) {
			return;
		}
		List<Book> books = getBookListFromTable();
		List<Book> filterList = new ArrayList<>();
		for (Book book : books) {
			if (ISBN.equals(book.getISBN())) {
				filterList.add(book);
			}
		}
		xoaDuLieuTrongTable();
		readBooksToTable(filterList);
	}

	private void filterByCategory() {
		String categoryFilter = txtCategory.getText();
		if (categoryFilter.trim().equals("")) {
			return;
		}
		List<Book> books = getBookListFromTable();
		List<Book> filterList = new ArrayList<>();
		for (Book book : books) {
			if (categoryFilter.equals(book.getCategory())) {
				filterList.add(book);
			}
		}
		xoaDuLieuTrongTable();
		readBooksToTable(filterList);
	}

	private void filterByLanguage() {
		String language = txtLanguage.getText();
		if (language.trim().equals(""))
			return;
		List<Book> books = getBookListFromTable();
		List<Book> dsLoc = new ArrayList<>();
		for (Book book : books) {
			if (language.equals(book.getLanguage())) {
				dsLoc.add(book);
			}
		}
		xoaDuLieuTrongTable();
		readBooksToTable(dsLoc);
	}

	private void filterByPrice() {
		Float price = Float.parseFloat(txtPrice.getText());
		if (txtPrice.getText().trim().equals(""))
			return;
		List<Book> books = getBookListFromTable();
		List<Book> dsLoc = new ArrayList<>();
		for (Book book : books) {
			if (book.getPrice() == price) {
				dsLoc.add(book);
			}
		}
		xoaDuLieuTrongTable();
		readBooksToTable(dsLoc);
	}

	private void filterByAuthorName() {
		String authorName = txtAuthorName.getText();
		if (authorName.trim().equals(""))
			return;
		List<Book> books = getBookListFromTable();
		List<Book> dsLoc = new ArrayList<>();
		for (Book book : books) {
			if (authorName.equals(book.getAuthorName())) {
				dsLoc.add(book);
			}
		}
		xoaDuLieuTrongTable();
		readBooksToTable(dsLoc);
	}

	private void filterByName() {
		String name = txtName.getText();
		if (name.trim().equals(""))
			return;
		List<Book> books = getBookListFromTable();
		List<Book> dsLoc = new ArrayList<>();
		for (Book book : books) {
			if (name.equals(book.getName())) {
				dsLoc.add(book);
			}
		}
		xoaDuLieuTrongTable();
		readBooksToTable(dsLoc);
	}

	private boolean kiemTraRong() {
		if(txtName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên sách không được rỗng!");
			txtName.selectAll();
			txtName.requestFocus();
			return false;
		}
		if(txtQuantity.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số lượng không được rỗng!");
			txtQuantity.selectAll();
			txtQuantity.requestFocus();
			return false;
		}
		if(txtAuthorName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên tác giả không được rỗng!");
			txtAuthorName.selectAll();
			txtAuthorName.requestFocus();
			return false;
		}

		if(txtPrice.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Giá sách không được rỗng!");
			txtPrice.selectAll();
			txtPrice.requestFocus();
			return false;
		}
		if(txtISBN.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "ISBN không được rỗng!");
			txtISBN.selectAll();
			txtISBN.requestFocus();
			return false;
		}

		if(txtLanguage.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Ngôn ngữ không được rỗng!");
			txtLanguage.selectAll();
			txtLanguage.requestFocus();
			return false;
		}
		if(txtCategory.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Thể loại không được rỗng!");
			txtCategory.selectAll();
			txtCategory.requestFocus();
			return false;
		}
		return true;
	}

}