package org.example.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.TextField;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KhachHang extends JPanel {

	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtHoTenKH;
	private JTextField txtNgaySinh;
	private JTextField txtNoiTamTru;
	private JTextField txtNoiThuongTru;
	private JTextField txtSoCCCD;
	private JTable table;
	private JTextField txtSoDienThoai;
	private JTextField txtTimKiem;


	/**
	 * Create the frame.
	 */
	public KhachHang() {
		setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 12));
		setBounds(100, 100, 1535, 500);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lbQLKH = new JLabel("Quản lý khách hàng");
		lbQLKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbQLKH.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lbQLKH.setBounds(453, 11, 540, 38);
		add(lbQLKH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(10, 49, 420, 360);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbMaKH = new JLabel("Mã khách hàng");
		lbMaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbMaKH.setBounds(25, 21, 125, 29);
		panel.add(lbMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(156, 26, 234, 20);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lbHoTenKH = new JLabel("Họ tên khách hàng");
		lbHoTenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbHoTenKH.setBounds(25, 61, 125, 29);
		panel.add(lbHoTenKH);
		
		txtHoTenKH = new JTextField();
		txtHoTenKH.setColumns(10);
		txtHoTenKH.setBounds(156, 103, 234, 20);
		panel.add(txtHoTenKH);
		
		JLabel lbNgaySinh = new JLabel("Ngày sinh");
		lbNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNgaySinh.setBounds(25, 140, 107, 20);
		panel.add(lbNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(156, 141, 234, 20);
		panel.add(txtNgaySinh);
		
		JLabel lbGioiTinh = new JLabel("Giới tính");
		lbGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbGioiTinh.setBounds(25, 224, 125, 14);
		panel.add(lbGioiTinh);
		
		JCheckBox checkboxNam = new JCheckBox("Nam");
		checkboxNam.setBounds(156, 221, 97, 23);
		panel.add(checkboxNam);
		
		JCheckBox checkboxNu = new JCheckBox("Nữ");
		checkboxNu.setBounds(259, 221, 97, 23);
		panel.add(checkboxNu);
		
		JLabel lbQueQuan = new JLabel("Tạm trú");
		lbQueQuan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbQueQuan.setBounds(25, 258, 61, 20);
		panel.add(lbQueQuan);
		
		txtNoiTamTru = new JTextField();
		txtNoiTamTru.setColumns(10);
		txtNoiTamTru.setBounds(156, 258, 234, 20);
		panel.add(txtNoiTamTru);
		
		JLabel lblNewLabel = new JLabel("Nơi thường trú");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(25, 301, 107, 20);
		panel.add(lblNewLabel);
		
		txtNoiThuongTru = new JTextField();
		txtNoiThuongTru.setColumns(10);
		txtNoiThuongTru.setBounds(156, 302, 234, 20);
		panel.add(txtNoiThuongTru);
		
		JLabel lbSoCCCD = new JLabel("Số CCCD");
		lbSoCCCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbSoCCCD.setBounds(25, 105, 97, 14);
		panel.add(lbSoCCCD);
		
		txtSoCCCD = new JTextField();
		txtSoCCCD.setColumns(10);
		txtSoCCCD.setBounds(156, 66, 234, 20);
		panel.add(txtSoCCCD);
		
		JLabel lbSoDienThoai = new JLabel("Số điện thoại");
		lbSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbSoDienThoai.setBounds(25, 186, 107, 14);
		panel.add(lbSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(156, 184, 234, 20);
		panel.add(txtSoDienThoai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(440, 54, 920, 349);
		add(panel_1);
		panel_1.setLayout(null);


		DefaultTableModel tableModel = new DefaultTableModel();

		tableModel.addColumn("Mã khách hàng");
		tableModel.addColumn("Họ tên");
		tableModel.addColumn("Số CCCD");
		tableModel.addColumn("Ngày sinh");
		tableModel.addColumn("Số điện thoại");
		tableModel.addColumn("Giới tính");
		tableModel.addColumn("Tạm trú");
		tableModel.addColumn("Thường trú");

//		KhachHang_DAO khachHangDao = new KhachHang_DAO();
//		ArrayList<KhachHang> data = khachHangDao.getAllKhachHang();
//		for(KhachHang khachHang : data) {
//			Boolean val = khachHang.getCccd().getGioiTinh();
//			String gioiTinh;
//			if(val == true) {
//				gioiTinh = "Nam";
//			}
//			else gioiTinh = "Nữ";
//			Object[]row = {khachHang.getMaKhachHang(), khachHang.getCccd().getHo() + " " + khachHang.getCccd().getHoDem() + " " + khachHang.getCccd().getTen(),
//			khachHang.getCccd().getMaCCCD(), khachHang.getCccd().getNgaySinh(), khachHang.getSoDienThoai(), gioiTinh, khachHang.getCccd().getTamTru(), khachHang.getCccd().getThuongTru()};
//			tableModel.addRow(row);
//		}
		this.table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				Object[] rowData = new Object[table.getColumnCount()];
				for (int i = 0; i < table.getColumnCount(); i++) {
					rowData[i] = table.getValueAt(row, i);
				}
				txtMaKH.setText(rowData[0].toString());
				txtHoTenKH.setText(rowData[1].toString());
				txtSoCCCD.setText(rowData[2].toString());
				txtNgaySinh.setText(rowData[3].toString());
				txtSoDienThoai.setText(rowData[4].toString());
				if(rowData[5].toString() == "Nam") {
					checkboxNam.setSelected(true);
					checkboxNu.setSelected(false);
				}
				else {
					checkboxNu.setSelected(true);
					checkboxNam.setSelected(false);
				}
				txtNoiTamTru.setText(rowData[6].toString());
				txtNoiThuongTru.setText(rowData[7].toString());
			}
		});
		JScrollPane scrollPane = new JScrollPane(this.table);
		scrollPane.setBounds(0, 0, 920, 349);
		panel_1.add(scrollPane);



		scrollPane.setViewportView(this.table);
		
		JLabel lbTimKiem = new JLabel("Nhập mã khách hàng hoặc số CCCD cần tìm");
		lbTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbTimKiem.setBounds(498, 423, 328, 30);
		add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTimKiem.setBounds(796, 428, 159, 20);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBounds(969, 427, 77, 23);
		add(btnTim);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setBounds(14, 427, 74, 23);
		add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setBounds(99, 426, 67, 23);
		add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setBounds(179, 425, 70, 23);
		add(btnSua);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLuu.setBounds(263, 425, 70, 23);
		add(btnLuu);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoat.setBounds(349, 424, 76, 23);
		add(btnThoat);
		
		JButton txtSapXepTheoHoTen = new JButton("Sắp xếp theo họ tên");
		txtSapXepTheoHoTen.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSapXepTheoHoTen.setBounds(1066, 427, 187, 23);
		add(txtSapXepTheoHoTen);
	}
}
