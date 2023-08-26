package org.example.gui;

import org.example.dao.CustomerDao;
import org.example.dao.impl.CustomerDaoImpl;
import org.example.entities.Book;
import org.example.entities.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GUI_Customer extends JPanel implements ActionListener, MouseListener {

	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtId;
    private JTextField txtEmail;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
    private JTextField txtGender;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnReload;
	private JButton btnFilter;
    private final CustomerDao customerDao;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public GUI_Customer() {
        customerDao = new CustomerDaoImpl();

		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel pThongTinKH = new JPanel();
		pThongTinKH.setBackground(new Color(255, 255, 255));
		pThongTinKH.setBounds(0, 0, 1180, 305);
		add(pThongTinKH);
		pThongTinKH.setLayout(null);
		pThongTinKH.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin khách hàng"));

		JPanel pMaKH = new JPanel();
		pMaKH.setBackground(new Color(255, 255, 255));
		pMaKH.setBounds(20, 21, 383, 45);
		pThongTinKH.add(pMaKH);
		pMaKH.setLayout(null);
		JLabel lblNewLabel = new JLabel("Mã khách hàng: ");
		lblNewLabel.setBounds(0, 12, 80, 14);
		pMaKH.add(lblNewLabel);
		txtId = new JTextField();
		txtId.setBounds(106, 5, 260, 29);
		pMaKH.add(txtId);
		txtId.setColumns(10);

		JPanel pTenKH = new JPanel();
		pTenKH.setBackground(new Color(255, 255, 255));
		pTenKH.setLayout(null);
		pTenKH.setBounds(20, 105, 383, 45);
		pThongTinKH.add(pTenKH);
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setBounds(0, 12, 82, 14);
		pTenKH.add(lblNewLabel_1);
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(106, 5, 260, 29);
		pTenKH.add(txtName);

		JPanel pEmail = new JPanel();
		pEmail.setBackground(new Color(255, 255, 255));
		pEmail.setLayout(null);
		pEmail.setBounds(20, 62, 383, 45);
		pThongTinKH.add(pEmail);
		JLabel lbISBN = new JLabel("Email:");
		lbISBN.setBounds(0, 12, 78, 14);
		pEmail.add(lbISBN);
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(106, 5, 260, 29);
		pEmail.add(txtEmail);

		JPanel pPhone = new JPanel();
		pPhone.setBackground(new Color(255, 255, 255));
		pPhone.setLayout(null);
		pPhone.setBounds(20, 194, 383, 45);
		pThongTinKH.add(pPhone);
		JLabel lblPhone = new JLabel("Số điện thoại:");
		lblPhone.setBounds(0, 12, 90, 14);
		pPhone.add(lblPhone);
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(106, 5, 260, 29);
		pPhone.add(txtPhone);

		JPanel pAddress = new JPanel();
		pAddress.setBackground(new Color(255, 255, 255));
		pAddress.setLayout(null);
		pAddress.setBounds(413, 21, 352, 45);
		pThongTinKH.add(pAddress);
		JLabel lblTacGia = new JLabel("Địa chỉ:");
		lblTacGia.setBounds(0, 12, 80, 14);
		pAddress.add(lblTacGia);
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(84, 8, 268, 26);
		pAddress.add(txtAddress);

		JPanel pGender = new JPanel();
		pGender.setBackground(new Color(255, 255, 255));
		pGender.setLayout(null);
		pGender.setBounds(413, 62, 352, 45);
		pThongTinKH.add(pGender);
		JLabel lblGender = new JLabel("Giới tính:");
		lblGender.setBounds(0, 12, 74, 14);
		pGender.add(lblGender);
		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(84, 8, 268, 26);
		pGender.add(txtGender);

		btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(75, 209, 254));
		btnAdd.setForeground(new Color(128, 0, 0));
		btnAdd.setBounds(20, 256, 98, 37);
		pThongTinKH.add(btnAdd);

		btnDelete = new JButton("Xóa");
		btnDelete.setIcon(new ImageIcon("data//xoa.png"));
		btnDelete.setForeground(new Color(128, 0, 0));
		btnDelete.setBackground(new Color(75, 209, 254));
		btnDelete.setBounds(128, 256, 98, 37);
		pThongTinKH.add(btnDelete);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setIcon(new ImageIcon("data//sua.png"));
		btnUpdate.setForeground(new Color(128, 0, 0));
		btnUpdate.setBackground(new Color(75, 209, 254));
		btnUpdate.setBounds(236, 256, 98, 37);
		pThongTinKH.add(btnUpdate);

		btnReload = new JButton("Làm mới");
		btnReload.setIcon(new ImageIcon("data//lamMoi.png"));
		btnReload.setForeground(new Color(128, 0, 0));
		btnReload.setBackground(new Color(75, 209, 254));
		btnReload.setBounds(345, 256, 122, 37);
		pThongTinKH.add(btnReload);

		btnFilter = new JButton("Lọc");
		btnFilter.setIcon(new ImageIcon("data//filter.png"));
		btnFilter.setForeground(new Color(128, 0, 0));
		btnFilter.setBackground(new Color(75, 209, 254));
		btnFilter.setBounds(480, 256, 98, 37);
		pThongTinKH.add(btnFilter);

		Box bTable = Box.createVerticalBox();
		bTable.setBounds(0, 305, 1180, 294);
		add(bTable);
		bTable.add(Box.createRigidArea(new Dimension(0, 5)));
		String head[] = { "Mã khách hàng", "Tên khách hàng", "Email", "Số điện thoại", "Địa chỉ", "Giới tính"};
		tableModel = new DefaultTableModel(head, 0);
		table = new JTable(tableModel);
		table.setBackground(new Color(255, 255, 255));
		bTable.add(new JScrollPane(table));

		List<Customer> customers =  customerDao.getAll();
		readCustomersToTable(customers);

		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(596, 253, 292, 38);
		pThongTinKH.add(lblError);

		btnReload.addActionListener(this);
		btnFilter.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);

		table.addMouseListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			addCustomer();
		}
		if (o.equals(btnDelete)) {
			deleteCustomer();
		}
		if (o.equals(btnUpdate)) {
			updateCustomer();
		}
		if (o.equals(btnReload)) {
			lamMoi();
		}
		if (o.equals(btnFilter)) {
			filterCustomer();
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
		txtAddress.setText(tableModel.getValueAt(row, 4).toString());
		txtName.setText(tableModel.getValueAt(row, 1).toString());
		txtGender.setText(tableModel.getValueAt(row, 5).toString());
		txtPhone.setText(tableModel.getValueAt(row, 3).toString());
		txtEmail.setText(tableModel.getValueAt(row, 2).toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void readCustomersToTable(List<Customer> customers) {
		for (Customer customer : customers) {
			tableModel.addRow(new Object[] { customer.getId(), customer.getFullName(), customer.getEmail(),
					customer.getPhone(), customer.getAddress(),  customer.getGender()});
		}
	}

	private void lamMoi() {
		txtEmail.setText("");
		txtGender.setText("");
		txtPhone.setText("");
		txtId.setText("");
		txtAddress.setText("");
		txtName.setText("");
		lblError.setText("");
		List<Customer> customers = customerDao.getAll();
		xoaDuLieuTrongTable();
		readCustomersToTable(customers);
	}

	private void xoaDuLieuTrongTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

	private void addCustomer() {
		if(!kiemTraRong())return ;
		String email = txtEmail.getText();
		String phone  = txtPhone.getText();
		String name = txtName.getText();
		String address = txtAddress.getText();
		String gender = txtGender.getText();
		LocalDateTime createdDate = LocalDateTime.now();
		LocalDateTime updatedDate = LocalDateTime.now();

		if (checkIfExistEmail(email) && checkIfExistPhone(phone)) {
			Customer customer = new Customer(name, email, phone, address, gender, createdDate, updatedDate);
			customerDao.save(customer);
			List<Customer> customers = customerDao.getAll();
			xoaDuLieuTrongTable();
			readCustomersToTable(customers);
		}
	}

	private boolean kiemTraChonHangTable(int row) {
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng trên table");
			return false;
		} else {
			return true;
		}
	}

	private void deleteCustomer() {
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
				customerDao.delete(id);
				xoaDuLieuTrongTable();
				List<Customer> customers = customerDao.getAll();
				readCustomersToTable(customers);
			}
		}
	}

	private void updateCustomer() {
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
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String address = txtAddress.getText();
				String email = txtEmail.getText();
				String gender = txtGender.getText();

				LocalDateTime updatedDate = LocalDateTime.now();
				Customer customer = new Customer(id, name, email, phone, address, gender, updatedDate);
				customerDao.update(customer);
				List<Customer> customers = customerDao.getAll();
				xoaDuLieuTrongTable();
				readCustomersToTable(customers);
			}
		}
	}

	private boolean checkIfExistEmail(String email) {
		List<Customer> customers = customerDao.getAll();
		for (Customer customer : customers) {
			if (email.trim().equals(customer.getEmail())) {
				return false;
			}
		}
		return true;
	}

	private boolean checkIfExistPhone(String phone) {
		List<Customer> customers = customerDao.getAll();
		for (Customer customer : customers) {
			if (phone.trim().equals(customer.getPhone())) {
				return false;
			}
		}
		return true;
	}

	private boolean validateEmail(String email) {
		if (email.equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được rỗng!");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		String regex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		if (!email.matches(regex)) {
			JOptionPane.showMessageDialog(this, "Email không hợp lệ. Ví dụ hợp lệ: xxx@gmail.com");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		} else {
			return true;
		}
	}


	private boolean validatePhone(String phone) {
		if (phone.equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng!");
			txtPhone.selectAll();
			txtPhone.requestFocus();
			return false;
		}
		String regex = "^[0-9]{10}$";
		if (!phone.matches(regex)) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải chứa đúng 10 chữ số. Ví dụ: 0822345678");
			txtPhone.selectAll();
			txtPhone.requestFocus();
			return false;
		} else {
			return true;
		}
	}


	private List<Customer> getCustomerListFromTable() {
		List<Customer> customers = new ArrayList<>();
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			Integer id = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
			String name = tableModel.getValueAt(i, 1).toString();
			String email = tableModel.getValueAt(i, 2).toString();
			String phone = tableModel.getValueAt(i, 3).toString();
			String address = tableModel.getValueAt(i, 4).toString();
			String gender = tableModel.getValueAt(i, 5).toString();

			Customer customer = new Customer(id, name, email, phone, address, gender);
			customers.add(customer);
		}
		return customers;
	}

	private void filterCustomer() {
		int result = JOptionPane.showConfirmDialog(this, "Bạn đã làm mới trang trước khi chọn lọc chưa?", "Xác nhận",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.NO_OPTION) {
			return;
		} else {
			xoaDuLieuTrongTable();
			List<Customer> customers = customerDao.getAll();
			readCustomersToTable(customers);
			filterByEmail();
			filterByName();
			filterByAddress();
			filterByGender();
			filterByPhone();
			List<Customer> customersFilter = getCustomerListFromTable();
			if(customersFilter.size()<=0) {
				lblError.setText("Không tìm thấy dữ liệu bạn tìm kiếm!!");
			}else lblError.setText("Tìm thấy!");
		}
	}

	private void filterByName() {
		String name = txtName.getText();
		if (name.trim().equals(""))
			return;
		List<Customer> customers = getCustomerListFromTable();
		List<Customer> dsLoc = new ArrayList<>();
		for (Customer customer : customers) {
			if (name.equals(customer.getFullName())) {
				customers.add(customer);
			}
		}
		xoaDuLieuTrongTable();
		readCustomersToTable(dsLoc);
	}

	private void filterByEmail() {
		String email = txtEmail.getText();
		if (email.trim().equals("")) {
			return;
		}
		List<Customer> customers = getCustomerListFromTable();
		List<Customer> filterList = new ArrayList<>();
		for (Customer customer : customers) {
			if (email.equals(customer.getEmail())) {
				filterList.add(customer);
			}
		}
		xoaDuLieuTrongTable();
		readCustomersToTable(filterList);
	}

	private void filterByPhone() {
		String phone = txtPhone.getText();
		if (phone.trim().equals("")) {
			return;
		}
		List<Customer> customers = getCustomerListFromTable();
		List<Customer> filterList = new ArrayList<>();
		for (Customer customer : customers) {
			if (phone.equals(customer.getPhone())) {
				filterList.add(customer);
			}
		}
		xoaDuLieuTrongTable();
		readCustomersToTable(filterList);
	}

	private void filterByAddress() {
		String address = txtAddress.getText();
		if (address.trim().equals(""))
			return;
		List<Customer> customers = getCustomerListFromTable();
		List<Customer> dsLoc = new ArrayList<>();
		for (Customer customer : customers) {
			if (address.toLowerCase().equals(customer.getAddress().toLowerCase())) {
				dsLoc.add(customer);
			}
		}
		xoaDuLieuTrongTable();
		readCustomersToTable(dsLoc);
	}

	private void filterByGender() {
		String gender = txtGender.getText().toLowerCase();
		if (txtGender.getText().trim().equals(""))
			return;
		List<Customer> customers = getCustomerListFromTable();
		List<Customer> dsLoc = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.getGender().toLowerCase().equals(gender)) {
				dsLoc.add(customer);
			}
		}
		xoaDuLieuTrongTable();
		readCustomersToTable(dsLoc);
	}
	private boolean kiemTraRong() {
		if(txtName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Họ tên không được rỗng!");
			txtName.selectAll();
			txtName.requestFocus();
			return false;
		}
		if(txtGender.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Giới tính không được rỗng!");
			txtGender.selectAll();
			txtGender.requestFocus();
			return false;
		}
		if(txtPhone.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng!");
			txtPhone.selectAll();
			txtPhone.requestFocus();
			return false;
		}

		if(txtEmail.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được rỗng!");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		if(txtAddress.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được rỗng!");
			txtAddress.selectAll();
			txtAddress.requestFocus();
			return false;
		}

		return true;
	}

}