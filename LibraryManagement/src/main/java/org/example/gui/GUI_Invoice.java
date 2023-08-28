package org.example.gui;

import org.example.dao.CustomerDao;
import org.example.dao.InvoiceDao;
import org.example.dao.RoleDao;
import org.example.dao.UserDao;
import org.example.dao.impl.CustomerDaoImpl;
import org.example.dao.impl.InvoiceDaoImpl;
import org.example.dao.impl.RoleDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.entities.*;
import org.example.entities.dto.InvoiceDto;

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


public class GUI_Invoice extends JPanel implements ActionListener, MouseListener {

	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtInvoiceId;
	private JTextField txtCustomerName;
	private JTextField txtAmount;
	private JTextField txtCustomerId;
	private JTextField txtBookName;
	private JButton btnXoa;
	private JButton btnLoc;
	private JButton btnLamMoi;
	private JTextField txtUpdatedDate;
	private UserDao userDao;
	private RoleDao roleDao;
	private JLabel lblLoiTimKiem;
	private final CustomerDao customerDao;
	private final InvoiceDao invoiceDao;

	/**
	 * Create the panel.
	 */
	public GUI_Invoice() {
		customerDao = new CustomerDaoImpl();
		invoiceDao = new InvoiceDaoImpl();
		roleDao = new RoleDaoImpl();
		userDao = new UserDaoImpl();

		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel pThongTinHoaDon = new JPanel();
		pThongTinHoaDon.setBackground(new Color(255, 255, 255));
		pThongTinHoaDon.setBounds(0, 0, 1180, 305);
		add(pThongTinHoaDon);
		pThongTinHoaDon.setLayout(null);
		pThongTinHoaDon.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin hoá đơn"));

		JPanel pId = new JPanel();
		pId.setBackground(new Color(255, 255, 255));
		pId.setBounds(20, 21, 383, 45);
		pThongTinHoaDon.add(pId);
		pId.setLayout(null);
		JLabel lblNewLabel = new JLabel("Mã hoá đơn: ");
		lblNewLabel.setBounds(0, 12, 80, 14);
		pId.add(lblNewLabel);
		txtInvoiceId = new JTextField();
		txtInvoiceId.setBounds(106, 5, 260, 29);
		pId.add(txtInvoiceId);
		txtInvoiceId.setColumns(10);
		txtInvoiceId.setEditable(false);

		JPanel pUsername = new JPanel();
		pUsername.setBackground(new Color(255, 255, 255));
		pUsername.setLayout(null);
		pUsername.setBounds(20, 62, 383, 45);
		pThongTinHoaDon.add(pUsername);
		JLabel lblNewLabel_2 = new JLabel("Mã khách hàng:");
		lblNewLabel_2.setBounds(0, 12, 78, 14);
		pUsername.add(lblNewLabel_2);
		txtCustomerId = new JTextField();
		txtCustomerId.setColumns(10);
		txtCustomerId.setBounds(106, 5, 260, 29);
		pUsername.add(txtCustomerId);

		JPanel pTenNhanVien = new JPanel();
		pTenNhanVien.setBackground(new Color(255, 255, 255));
		pTenNhanVien.setLayout(null);
		pTenNhanVien.setBounds(20, 105, 383, 45);
		pThongTinHoaDon.add(pTenNhanVien);
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setBounds(0, 12, 82, 14);
		pTenNhanVien.add(lblNewLabel_1);
		txtCustomerName = new JTextField();
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(106, 5, 260, 29);
		pTenNhanVien.add(txtCustomerName);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(810, 21, 345, 246);
		pThongTinHoaDon.add(panel_2);
		JPanel pAmount = new JPanel();
		pAmount.setLayout(null);
		pAmount.setBackground(Color.WHITE);
		pAmount.setBounds(20, 149, 383, 45);
		pThongTinHoaDon.add(pAmount);
		JLabel lblAmount = new JLabel("Tổng đơn:");
		lblAmount.setBounds(0, 12, 106, 14);
		pAmount.add(lblAmount);
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(106, 5, 260, 29);
		pAmount.add(txtAmount);

		JPanel pUpdatedDate = new JPanel();
		pUpdatedDate.setBackground(new Color(255, 255, 255));
		pUpdatedDate.setLayout(null);
		pUpdatedDate.setBounds(413, 21, 352, 45);
		pThongTinHoaDon.add(pUpdatedDate);
		JLabel lblGender = new JLabel("Ngày tạo đơn:");
		lblGender.setBounds(0, 12, 80, 14);
		pUpdatedDate.add(lblGender);
		txtUpdatedDate = new JTextField();
		txtUpdatedDate.setEditable(true);
		txtUpdatedDate.setBounds(84, 8, 268, 26);
		pUpdatedDate.add(txtUpdatedDate);

		JPanel pBookNames = new JPanel();
		pBookNames.setBackground(new Color(255, 255, 255));
		pBookNames.setLayout(null);
		pBookNames.setBounds(413, 105, 352, 45);
		pThongTinHoaDon.add(pBookNames);
		JLabel lblBookNames = new JLabel("Tên sách:");
		lblBookNames.setBounds(0, 12, 74, 14);
		pBookNames.add(lblBookNames);
		txtBookName = new JTextField();
		txtBookName.setColumns(10);
		txtBookName.setBounds(84, 5, 268, 29);
		pBookNames.add(txtBookName);

		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(128, 0, 0));
		btnXoa.setBackground(new Color(75, 209, 254));
		btnXoa.setBounds(128, 256, 98, 37);
		pThongTinHoaDon.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(new Color(128, 0, 0));
		btnLamMoi.setBackground(new Color(75, 209, 254));
		btnLamMoi.setBounds(236, 256, 98, 37);
		pThongTinHoaDon.add(btnLamMoi);

		btnLoc = new JButton("Lọc");
		btnLoc.setForeground(new Color(128, 0, 0));
		btnLoc.setBackground(new Color(75, 209, 254));
		btnLoc.setBounds(345, 256, 122, 37);
		pThongTinHoaDon.add(btnLoc);

		Box bTable = Box.createVerticalBox();
		bTable.setBounds(0, 305, 1180, 294);
		add(bTable);
		bTable.add(Box.createRigidArea(new Dimension(0, 5)));
		String head[] = { "Mã hoá đơn", "Ngày tạo đơn", "Mã khách hàng", "Tên khách hàng", "Tên sách",
				"Tổng đơn" };
		tableModel = new DefaultTableModel(head, 0);
		table = new JTable(tableModel);
		table.setBackground(new Color(255, 255, 255));
		bTable.add(new JScrollPane(table));

		List<Invoice> invoices = invoiceDao.getAll();
		readInvoiceToTable(invoices);

		lblLoiTimKiem = new JLabel("");
		lblLoiTimKiem.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLoiTimKiem.setForeground(new Color(255, 0, 0));
		lblLoiTimKiem.setBounds(596, 253, 292, 38);
		pThongTinHoaDon.add(lblLoiTimKiem);

		btnLamMoi.addActionListener(this);
		btnLoc.addActionListener(this);
		btnXoa.addActionListener(this);

		table.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoa)) {
			deleteInvoice();
		}
		if (o.equals(btnLamMoi)) {
			lamMoi();
		}
		if (o.equals(btnLoc)) {
			filterInvoice();
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
		txtInvoiceId.setText(tableModel.getValueAt(row, 0).toString());
		txtUpdatedDate.setText(tableModel.getValueAt(row, 1).toString());
		txtCustomerId.setText(tableModel.getValueAt(row, 2).toString());
		txtCustomerName.setText(tableModel.getValueAt(row, 3).toString());
		txtBookName.setText(tableModel.getValueAt(row, 4).toString());
		txtAmount.setText(tableModel.getValueAt(row, 5).toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void readInvoiceToTable(List<Invoice> invoices) {
		for (Invoice invoice : invoices) {
			Customer customer = customerDao.getOne(invoice.getCustomer().getId());
			List<Book> books = invoiceDao.getBooksByInvoiceId(invoice.getId()).stream().toList();
			String bookNames = "";
			for (Book book:
				 books) {
				bookNames += book.getName() + "; ";
			}
			tableModel.addRow(new Object[] { invoice.getId(), invoice.getUpdatedDate(), customer.getId(),
					customer.getFullName(), bookNames, invoice.getAmount()});
		}
	}

	private void readInvoiceToTable2(List<InvoiceDto> invoices) {
		for (InvoiceDto invoice : invoices) {
			Customer customer = customerDao.getOne(invoice.getCustomer().getId());
			tableModel.addRow(new Object[] { invoice.getId(), invoice.getUpdatedDate(), customer.getId(),
					customer.getFullName(), invoice.getBookNames(), invoice.getAmount()});
		}
	}
	private void lamMoi() {
		txtBookName.setText("");
		txtAmount.setText("");
		txtInvoiceId.setText("");
		txtCustomerId.setText("");
		txtCustomerName.setText("");
		txtUpdatedDate.setText("");
		lblLoiTimKiem.setText("");
		List<Invoice> invoices = invoiceDao.getAll();
		xoaDuLieuTrongTable();
		readInvoiceToTable(invoices);
	}

	private void xoaDuLieuTrongTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

	private boolean kiemTraChonHangTable(int row) {
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng dòng trên table");
			return false;
		} else {
			return true;
		}
	}

	private void deleteInvoice() {
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
				invoiceDao.delete(id);
				xoaDuLieuTrongTable();
				List<Invoice> invoices = invoiceDao.getAll();
				readInvoiceToTable(invoices);
			}
		}
	}
	private List<InvoiceDto> getInvoicesFromTable() {
		List<InvoiceDto> invoices = new ArrayList<>();
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			Integer invoiceId = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
			LocalDateTime updatedDate = LocalDateTime.parse(tableModel.getValueAt(i, 1).toString());
			Integer customerId = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
			String bookNames = tableModel.getValueAt(i, 4).toString();
			Float amount = Float.parseFloat(tableModel.getValueAt(i, 5).toString());

			Customer customer = customerDao.getOne(customerId);
			InvoiceDto invoice = new InvoiceDto(invoiceId, updatedDate, customer, bookNames, amount);
			invoices.add(invoice);
		}
		return invoices;
	}

	private void filterInvoice() {
		int result = JOptionPane.showConfirmDialog(this, "Bạn đã làm mới trang trước khi chọn lọc chưa?", "Xác nhận",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.NO_OPTION) {
			return;
		} else {
			xoaDuLieuTrongTable();
			List<Invoice> invoices = invoiceDao.getAll();
			readInvoiceToTable(invoices);
			filterByCustomerId();
			List<InvoiceDto> invoicesFilter = getInvoicesFromTable();
			if(invoicesFilter.size()<=0) {
				lblLoiTimKiem.setText("Không tìm thấy dữ liệu bạn tìm kiếm!!");
			}else lblLoiTimKiem.setText("Tìm thấy!");
		}
	}
	private void filterByCustomerId() {
		if (txtCustomerId.getText().trim().isEmpty())
			return;
		Integer id = Integer.parseInt(txtCustomerId.getText());
		List<InvoiceDto> invoices = getInvoicesFromTable();
		List<InvoiceDto> dsLoc = new ArrayList<>();
		for (InvoiceDto invoice : invoices) {
			if (id == invoice.getCustomer().getId()) {
				dsLoc.add(invoice);
			}
		}
		xoaDuLieuTrongTable();
		readInvoiceToTable2(dsLoc);
	}
}