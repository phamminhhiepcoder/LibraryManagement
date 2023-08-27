package org.example.gui;

import org.example.dao.RoleDao;
import org.example.dao.UserDao;
import org.example.dao.impl.RoleDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.entities.Role;
import org.example.entities.Users;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class GUI_User extends JPanel implements ActionListener, MouseListener {

	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtId;
	private JTextField txtFullName;
	private JTextField txtPassword;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnLoc;
	private JTextField txtAddress;
	private JComboBox cbxRole;
	private JComboBox<String> cbxGender;
	private UserDao userDao;
	private RoleDao roleDao;
	private JLabel lblLoiTimKiem;

	/**
	 * Create the panel.
	 */
	public GUI_User() {

		roleDao = new RoleDaoImpl();
		userDao = new UserDaoImpl();

		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel pThongTinNhanVien = new JPanel();
		pThongTinNhanVien.setBackground(new Color(255, 255, 255));
		pThongTinNhanVien.setBounds(0, 0, 1180, 305);
		add(pThongTinNhanVien);
		pThongTinNhanVien.setLayout(null);
		pThongTinNhanVien.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin nhân viên"));

		JPanel pId = new JPanel();
		pId.setBackground(new Color(255, 255, 255));
		pId.setBounds(20, 21, 383, 45);
		pThongTinNhanVien.add(pId);
		pId.setLayout(null);
		JLabel lblNewLabel = new JLabel("Id: ");
		lblNewLabel.setBounds(0, 12, 80, 14);
		pId.add(lblNewLabel);
		txtId = new JTextField();
		txtId.setBounds(106, 5, 260, 29);
		pId.add(txtId);
		txtId.setColumns(10);

		JPanel pTenNhanVien = new JPanel();
		pTenNhanVien.setBackground(new Color(255, 255, 255));
		pTenNhanVien.setLayout(null);
		pTenNhanVien.setBounds(20, 105, 383, 45);
		pThongTinNhanVien.add(pTenNhanVien);
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1.setBounds(0, 12, 82, 14);
		pTenNhanVien.add(lblNewLabel_1);
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(106, 5, 260, 29);
		pTenNhanVien.add(txtFullName);

		JPanel pUsername = new JPanel();
		pUsername.setBackground(new Color(255, 255, 255));
		pUsername.setLayout(null);
		pUsername.setBounds(20, 62, 383, 45);
		pThongTinNhanVien.add(pUsername);
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(0, 12, 78, 14);
		pUsername.add(lblNewLabel_2);
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(106, 5, 260, 29);
		pUsername.add(txtUsername);

		JPanel pPassword = new JPanel();
		pPassword.setBackground(new Color(255, 255, 255));
		pPassword.setLayout(null);
		pPassword.setBounds(20, 194, 383, 45);
		pThongTinNhanVien.add(pPassword);
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu:");
		lblNewLabel_3.setBounds(0, 12, 90, 14);
		pPassword.add(lblNewLabel_3);
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(106, 5, 260, 29);
		pPassword.add(txtPassword);

		JPanel pGender = new JPanel();
		pGender.setBackground(new Color(255, 255, 255));
		pGender.setLayout(null);
		pGender.setBounds(413, 21, 352, 45);
		pThongTinNhanVien.add(pGender);
		JLabel lblGender = new JLabel("Giới tính:");
		lblGender.setBounds(0, 12, 80, 14);
		pGender.add(lblGender);
		String[] genders = {"Male", "Female"};
		cbxGender = new JComboBox<>(genders);
		cbxGender.setEditable(true);
		cbxGender.setBounds(84, 8, 268, 26);
		pGender.add(cbxGender);

		JPanel pRole = new JPanel();
		pRole.setBackground(new Color(255, 255, 255));
		pRole.setLayout(null);
		pRole.setBounds(413, 62, 352, 45);
		pThongTinNhanVien.add(pRole);
		JLabel lblNewLabel_5 = new JLabel("Chức vụ:");
		lblNewLabel_5.setBounds(0, 12, 74, 14);
		pRole.add(lblNewLabel_5);
		cbxRole = new JComboBox();
		cbxRole.setEditable(true);
		cbxRole.setBounds(84, 8, 268, 26);
		pRole.add(cbxRole);
		readRoleToComboBox();

		JPanel pEmail = new JPanel();
		pEmail.setBackground(new Color(255, 255, 255));
		pEmail.setLayout(null);
		pEmail.setBounds(413, 105, 352, 45);
		pThongTinNhanVien.add(pEmail);
		JLabel lblNewLabel_6 = new JLabel("Email:");
		lblNewLabel_6.setBounds(0, 12, 74, 14);
		pEmail.add(lblNewLabel_6);
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(84, 5, 268, 29);
		pEmail.add(txtEmail);

		JPanel pPhone = new JPanel();
		pPhone.setBackground(new Color(255, 255, 255));
		pPhone.setLayout(null);
		pPhone.setBounds(413, 149, 352, 45);
		pThongTinNhanVien.add(pPhone);
		JLabel lblNewLabel_7 = new JLabel("Điện thoại:");
		lblNewLabel_7.setBounds(0, 12, 84, 14);
		pPhone.add(lblNewLabel_7);
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(84, 5, 268, 29);
		pPhone.add(txtPhone);

		Image imgThem = new ImageIcon("data//them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(imgThem));
		btnThem.setBackground(new Color(75, 209, 254));
		btnThem.setForeground(new Color(128, 0, 0));
		btnThem.setBounds(20, 256, 98, 37);
		pThongTinNhanVien.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("data//xoa.png"));
		btnXoa.setForeground(new Color(128, 0, 0));
		btnXoa.setBackground(new Color(75, 209, 254));
		btnXoa.setBounds(128, 256, 98, 37);
		pThongTinNhanVien.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("data//sua.png"));
		btnSua.setForeground(new Color(128, 0, 0));
		btnSua.setBackground(new Color(75, 209, 254));
		btnSua.setBounds(236, 256, 98, 37);
		pThongTinNhanVien.add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("data//lamMoi.png"));
		btnLamMoi.setForeground(new Color(128, 0, 0));
		btnLamMoi.setBackground(new Color(75, 209, 254));
		btnLamMoi.setBounds(345, 256, 122, 37);
		pThongTinNhanVien.add(btnLamMoi);

		btnLoc = new JButton("Lọc");
		btnLoc.setIcon(new ImageIcon("data//filter.png"));
		btnLoc.setForeground(new Color(128, 0, 0));
		btnLoc.setBackground(new Color(75, 209, 254));
		btnLoc.setBounds(480, 256, 98, 37);
		pThongTinNhanVien.add(btnLoc);

		Box bTable = Box.createVerticalBox();
		bTable.setBounds(0, 305, 1180, 294);
		add(bTable);
		bTable.add(Box.createRigidArea(new Dimension(0, 5)));
		String head[] = { "Id", "Tên nhân viên", "Tên tài khoản", "Mật khẩu", "Email", "Điện thoại", "Địa chỉ",
				"Giới tính", "Quyền" };
		tableModel = new DefaultTableModel(head, 0);
		table = new JTable(tableModel);
		table.setBackground(new Color(255, 255, 255));
		bTable.add(new JScrollPane(table));

		List<Users> users = userDao.getAll();
		readUsersToTable(users);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(810, 21, 345, 246);
		pThongTinNhanVien.add(panel_2);
		JPanel pAddress = new JPanel();
		pAddress.setLayout(null);
		pAddress.setBackground(Color.WHITE);
		pAddress.setBounds(20, 149, 383, 45);
		pThongTinNhanVien.add(pAddress);
		JLabel lblNewLabel_3_1 = new JLabel("Địa chỉ:");
		lblNewLabel_3_1.setBounds(0, 12, 106, 14);
		pAddress.add(lblNewLabel_3_1);
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(106, 5, 260, 29);
		pAddress.add(txtAddress);

		lblLoiTimKiem = new JLabel("");
		lblLoiTimKiem.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLoiTimKiem.setForeground(new Color(255, 0, 0));
		lblLoiTimKiem.setBounds(596, 253, 292, 38);
		pThongTinNhanVien.add(lblLoiTimKiem);

		btnLamMoi.addActionListener(this);
		btnLoc.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);

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
		if (o.equals(btnThem)) {
			addUser();
		}
		if (o.equals(btnXoa)) {
			deleteUser();
		}
		if (o.equals(btnSua)) {
			updateUser();
		}
		if (o.equals(btnLamMoi)) {
			lamMoi();
		}
		if (o.equals(btnLoc)) {
			filterUser();
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
		txtFullName.setText(tableModel.getValueAt(row, 1).toString());
		txtUsername.setText(tableModel.getValueAt(row, 2).toString());
		txtPassword.setText(tableModel.getValueAt(row, 3).toString());
		txtEmail.setText(tableModel.getValueAt(row, 4).toString());
		txtPhone.setText(tableModel.getValueAt(row, 5).toString());
		txtAddress.setText(tableModel.getValueAt(row, 6).toString());
		cbxGender.setSelectedItem(tableModel.getValueAt(row, 7).toString());
		cbxRole.setSelectedItem(tableModel.getValueAt(row, 8).toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	private void readRoleToComboBox() {
		List<Role> roles = roleDao.getAll();
		SortedSet<String> names = new TreeSet<String>();
		cbxRole.addItem("");
		for (Role role : roles) {
			names.add(role.getName());
		}
		for (String name : names) {
			cbxRole.addItem(name);
		}
	}

	/**
	 * đọc danh sách users vào table
	 */
	private void readUsersToTable(List<Users> users) {
		for (Users user : users) {
			Role role = roleDao.getOne(user.getRole().getId());
			tableModel.addRow(new Object[] { user.getId(), user.getFullName(), user.getUsername(),
					user.getPassword(), user.getEmail(), user.getPhone(), user.getAddress(),
					user.getGender(), role.getName()});
		}
	}

	private void lamMoi() {
		txtEmail.setText("");
		txtPhone.setText("");
		txtAddress.setText("");
		txtPassword.setText("");
		txtId.setText("");
		txtPassword.setText("");
		txtFullName.setText("");
		cbxGender.setSelectedIndex(0);
		cbxRole.setSelectedIndex(0);
		lblLoiTimKiem.setText("");
		List<Users> users = userDao.getAll();
		xoaDuLieuTrongTable();
		readUsersToTable(users);
	}

	private void xoaDuLieuTrongTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

	private void addUser() {

		String password = txtPassword.getText();
		String fullName = txtFullName.getText();
		String gender = cbxGender.getSelectedItem().toString();
		String email = txtEmail.getText();
		String address = txtAddress.getText();
		String username = txtUsername.getText();
		String phone = txtPhone.getText();
		String roleName = cbxRole.getSelectedItem().toString();
		LocalDateTime createdDate = LocalDateTime.now();
		LocalDateTime updatedDate = LocalDateTime.now();
		Role role = roleDao.findByName(roleName);
		Users user = new Users(fullName, username, password, email, phone, address, gender,createdDate, updatedDate, role);
		userDao.save(user);
		xoaDuLieuTrongTable();
		List<Users> users = userDao.getAll();
		readUsersToTable(users);
		}

	private boolean checkIfExistEmail(String email) {
		List<Users> users = userDao.getAll();
		for (Users user : users) {
			if (email.trim().equals(user.getEmail())) {
				return false;
			}
		}
		return true;
	}

	private boolean checkIfExistPhone(String phone) {
		List<Users> users = userDao.getAll();
		for (Users user : users) {
			if (phone.trim().equals(user.getPhone())) {
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraChonHangTable(int row) {
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng dòng trên table");
			return false;
		} else {
			return true;
		}
	}

	private void deleteUser() {
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
				userDao.delete(id);
				xoaDuLieuTrongTable();
				List<Users> users = userDao.getAll();
				readUsersToTable(users);
			}
		}
	}

	private void updateUser() {
		int row = table.getSelectedRow();
		if (kiemTraChonHangTable(row)) {
			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không !!!");
			if (result == JOptionPane.NO_OPTION) {
				lamMoi();
				return;
			} else if (result == JOptionPane.CANCEL_OPTION) {
				return;
			} else {
				Integer id = Integer.parseInt(txtId.getText());
				String password = txtPassword.getText();
				String fullName = txtFullName.getText();
				String gender = cbxGender.getSelectedItem().toString();
				String email = txtEmail.getText();
				String address = txtAddress.getText();
				String username = txtUsername.getText();
				String phone = txtPhone.getText();
				String roleName = cbxRole.getSelectedItem().toString();
				LocalDateTime updatedDate = LocalDateTime.now();
				Role role = roleDao.findByName(roleName);
				Users user = new Users(id, fullName, username, password, email, phone, address, gender, updatedDate, role);
				userDao.update(user);
				xoaDuLieuTrongTable();
				List<Users> users = userDao.getAll();
				readUsersToTable(users);
			}
		}
	}

	private List<Users> getUsersFromTable() {
		List<Users> users = new ArrayList<>();
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			Integer id = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
			String fullName = tableModel.getValueAt(i, 1).toString();
			String username = tableModel.getValueAt(i, 2).toString();
			String password = tableModel.getValueAt(i, 3).toString();
			String email = tableModel.getValueAt(i, 4).toString();
			String phone = tableModel.getValueAt(i, 5).toString();
			String address = tableModel.getValueAt(i, 6).toString();
			String gender = tableModel.getValueAt(i, 7).toString();
			String roleName = tableModel.getValueAt(i, 8).toString();

			Role role = roleDao.findByName(roleName);
			Users user = new Users(id, fullName, username, password, email, phone, address, gender, role);
			users.add(user);
		}
		return users;
	}

	private void filterUser() {
		int result = JOptionPane.showConfirmDialog(this, "Bạn đã làm mới trang trước khi chọn lọc chưa?", "Xác nhận",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.NO_OPTION) {
			return;
		} else {
			xoaDuLieuTrongTable();
			List<Users> users = userDao.getAll();
			readUsersToTable(users);
			filterByEmail();
			filterByFullName();
			filterByUsername();
			filterByAddress();
			filterByGender();
			filterByPhone();
			List<Users> usersFilter = getUsersFromTable();
			if(usersFilter.size()<=0) {
				lblLoiTimKiem.setText("Không tìm thấy dữ liệu bạn tìm kiếm!!");
			}else lblLoiTimKiem.setText("Tìm thấy!");
		}
	}

	private void filterByFullName() {
		String name = txtFullName.getText();
		if (name.trim().equals(""))
			return;
		List<Users> users = getUsersFromTable();
		List<Users> dsLoc = new ArrayList<>();
		for (Users user : users) {
			if (name.equals(user.getFullName())) {
				dsLoc.add(user);
			}
		}
		xoaDuLieuTrongTable();
		readUsersToTable(dsLoc);
	}

	private void filterByUsername() {
		String username = txtUsername.getText();
		if (username.trim().equals(""))
			return;
		List<Users> users = getUsersFromTable();
		List<Users> dsLoc = new ArrayList<>();
		for (Users user : users) {
			if (username.equals(user.getUsername())) {
				dsLoc.add(user);
			}
		}
		xoaDuLieuTrongTable();
		readUsersToTable(dsLoc);
	}

	private void filterByEmail() {
		String email = txtEmail.getText();
		if (email.trim().equals("")) {
			return;
		}
		List<Users> users = getUsersFromTable();
		List<Users> filterList = new ArrayList<>();
		for (Users user : users) {
			if (email.equals(user.getEmail())) {
				filterList.add(user);
			}
		}
		xoaDuLieuTrongTable();
		readUsersToTable(filterList);
	}

	private void filterByPhone() {
		String phone = txtPhone.getText();
		if (phone.trim().equals("")) {
			return;
		}
		List<Users> users = getUsersFromTable();
		List<Users> filterList = new ArrayList<>();
		for (Users user : users) {
			if (phone.equals(user.getPhone())) {
				filterList.add(user);
			}
		}
		xoaDuLieuTrongTable();
		readUsersToTable(filterList);
	}

	private void filterByAddress() {
		String address = txtAddress.getText();
		if (address.trim().equals("")) {
			return;
		}
		List<Users> users = getUsersFromTable();
		List<Users> filterList = new ArrayList<>();
		for (Users user : users) {
			if (address.equals(user.getAddress())) {
				filterList.add(user);
			}
		}
		xoaDuLieuTrongTable();
		readUsersToTable(filterList);
	}

	private void filterByGender() {
		String gender = cbxGender.getSelectedItem().toString().toLowerCase();
		if (gender.equals(""))
			return;
		List<Users> users = getUsersFromTable();
		List<Users> dsLoc = new ArrayList<>();
		for (Users user : users) {
			if (user.getGender().toLowerCase().equals(gender)) {
				dsLoc.add(user);
			}
		}
		xoaDuLieuTrongTable();
		readUsersToTable(dsLoc);
	}

	private boolean kiemTraRong() {
		if(txtFullName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên không được rỗng!");
			txtFullName.selectAll();
			txtFullName.requestFocus();
			return false;
		}
		if(txtAddress.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được rỗng!");
			txtAddress.selectAll();
			txtAddress.requestFocus();
			return false;
		}
		if(txtPassword.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được rỗng!");
			txtPassword.selectAll();
			txtPassword.requestFocus();
			return false;
		}
		if(cbxGender.getSelectedItem().toString().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính!");
			return false;
		}if(cbxRole.getSelectedItem().toString().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn quyền!");
			return false;
		}
		if(txtEmail.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được rỗng!");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		if(txtPhone.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng!");
			txtPhone.selectAll();
			txtPhone.requestFocus();
			return false;
		}

		return true;
	}

}