<<<<<<< HEAD
package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rsbuttom.RSButtonMetro;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel_1;
	private JPanel panel_playlist;

	
	public Inicio() {
		setTitle("Music App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 657);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setAlignmentY(0.0f);
		panel.setAlignmentX(0.0f);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_inferior = new JPanel();
		panel_inferior.setBounds(0, 511, 977, 89);
		panel_inferior.setBackground(new Color(55,55,55));
		panel_inferior.setForeground(Color.WHITE);
		
		JPanel panel_izq = new JPanel();
		panel_izq.setBounds(0, 0, 174, 511);
		panel_izq.setBackground(Color.DARK_GRAY);
		panel_izq.setForeground(Color.GRAY);
		panel_izq.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JPanel panel_der = new JPanel();
		panel_der.setBounds(803, 0, 174, 511);
		panel_der.setBackground(Color.DARK_GRAY);
		panel_izq.setLayout(null);
		
		JPanel panel_central = new JPanel();
		panel_central.setForeground(UIManager.getColor("Panel.background"));
		panel_central.setBounds(175, 0, 627, 511);
		panel_central.setBackground(UIManager.getColor("Panel.background"));
		panel_central.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 627, 511);
		scrollPane.setBackground(new Color(105, 105, 105));
		panel_central.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		panel.setLayout(null);
		panel.add(panel_inferior);
		panel_inferior.setLayout(null);
		
		RSButtonMetro btnPlay = new RSButtonMetro();
		btnPlay.setColorHover(Color.DARK_GRAY);
		btnPlay.setColorBorde(null);
		btnPlay.setColorNormal(new Color(55,55,55));
		btnPlay.setBackground(new Color(55,55,55));
		btnPlay.setIcon(new ImageIcon(Inicio.class.getResource("/icons/Button-Play-icon.png")));
		btnPlay.setBounds(455, 20, 66, 50);
		panel_inferior.add(btnPlay);
		
		RSButtonMetro btnPause = new RSButtonMetro();
		btnPause.setColorHover(Color.DARK_GRAY);
		btnPause.setColorNormal(new Color(55,55,55));
		btnPause.setBackground(new Color(55,55,55));
		btnPause.setIcon(new ImageIcon(Inicio.class.getResource("/icons/Button-Pause-icon.png")));
		btnPause.setBounds(395, 20, 48, 50);
		panel_inferior.add(btnPause);
		panel.add(panel_izq);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 174, 376);
		panel_izq.add(panel_1);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);
		
		RSButtonMetro btnPlaylists = new RSButtonMetro();
		btnPlaylists.setBounds(0, 0, 174, 65);
		panel_1.add(btnPlaylists);
		btnPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel_1.setVisible(false);
				panel_playlist.setVisible(true);
				
				Animacion.Animacion.mover_izquierda(0, -188, 2, 2, panel_izq);
				
				try {
					Thread.sleep(150);
				}
				catch(InterruptedException e1){
					System.out.println("Thread Interrupted");
				}
				
				Animacion.Animacion.mover_derecha(-188, 0, 2, 2, panel_izq);
			}
		});
		btnPlaylists.setColorPressed(Color.LIGHT_GRAY);
		btnPlaylists.setColorHover(Color.GRAY);
		btnPlaylists.setText("Playlists");
		btnPlaylists.setColorNormal(Color.DARK_GRAY);
		btnPlaylists.setForeground(Color.WHITE);
		btnPlaylists.setBackground(Color.DARK_GRAY);
		
		panel_playlist = new JPanel();
		panel_playlist.setBounds(0, 0, 174, 376);
		panel_izq.add(panel_playlist);
		panel_playlist.setLayout(null);
		panel_playlist.setBackground(Color.DARK_GRAY);
		panel_playlist.setVisible(false);
		
		RSButtonMetro btnCrearPlaylist = new RSButtonMetro();
		btnCrearPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(null,"Introduzca el nombre de playlist: ","Playlist",JOptionPane.INFORMATION_MESSAGE);;
			}
		});
		btnCrearPlaylist.setText("Crear playlist");
		btnCrearPlaylist.setForeground(Color.WHITE);
		btnCrearPlaylist.setColorPressed(Color.LIGHT_GRAY);
		btnCrearPlaylist.setColorNormal(Color.DARK_GRAY);
		btnCrearPlaylist.setColorHover(Color.GRAY);
		btnCrearPlaylist.setBackground(Color.DARK_GRAY);
		btnCrearPlaylist.setBounds(0, 70, 174, 65);
		panel_playlist.add(btnCrearPlaylist);
		
		RSButtonMetro btnAtras = new RSButtonMetro();
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_playlist.setVisible(false);
				panel_1.setVisible(true);
				
				Animacion.Animacion.mover_izquierda(0, -188, 2, 2, panel_izq);
				
				try {
					Thread.sleep(150);
				}
				catch(InterruptedException e1){
					System.out.println("Thread Interrupted");
				}
				
				Animacion.Animacion.mover_derecha(-188, 0, 2, 2, panel_izq);
			}
		});
		btnAtras.setText("<- Atr\u00E1s");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setColorPressed(Color.LIGHT_GRAY);
		btnAtras.setColorNormal(Color.DARK_GRAY);
		btnAtras.setColorHover(Color.GRAY);
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setBounds(0, 0, 174, 65);
		panel_playlist.add(btnAtras);
		
		RSButtonMetro btnCargarPlaylist = new RSButtonMetro();
		btnCargarPlaylist.setText("Listar playlists");
		btnCargarPlaylist.setForeground(Color.WHITE);
		btnCargarPlaylist.setColorPressed(Color.LIGHT_GRAY);
		btnCargarPlaylist.setColorNormal(Color.DARK_GRAY);
		btnCargarPlaylist.setColorHover(Color.GRAY);
		btnCargarPlaylist.setBackground(Color.DARK_GRAY);
		btnCargarPlaylist.setBounds(0, 147, 174, 65);
		panel_playlist.add(btnCargarPlaylist);
		panel.add(panel_der);
		panel.add(panel_central);
	}
}
=======
package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rsbuttom.RSButtonMetro;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel_1;
	private JPanel panel_playlist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setTitle("Music App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 657);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setAlignmentY(0.0f);
		panel.setAlignmentX(0.0f);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_inferior = new JPanel();
		panel_inferior.setBounds(0, 511, 977, 89);
		panel_inferior.setBackground(new Color(55,55,55));
		panel_inferior.setForeground(Color.WHITE);
		
		JPanel panel_izq = new JPanel();
		panel_izq.setBounds(0, 0, 174, 511);
		panel_izq.setBackground(Color.DARK_GRAY);
		panel_izq.setForeground(Color.GRAY);
		panel_izq.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JPanel panel_der = new JPanel();
		panel_der.setBounds(803, 0, 174, 511);
		panel_der.setBackground(Color.DARK_GRAY);
		panel_izq.setLayout(null);
		
		JPanel panel_central = new JPanel();
		panel_central.setForeground(UIManager.getColor("Panel.background"));
		panel_central.setBounds(175, 0, 627, 511);
		panel_central.setBackground(UIManager.getColor("Panel.background"));
		panel_central.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 627, 511);
		scrollPane.setBackground(new Color(105, 105, 105));
		panel_central.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		panel.setLayout(null);
		panel.add(panel_inferior);
		panel_inferior.setLayout(null);
		
		RSButtonMetro btnPlay = new RSButtonMetro();
		btnPlay.setColorHover(Color.DARK_GRAY);
		btnPlay.setColorBorde(null);
		btnPlay.setColorNormal(new Color(55,55,55));
		btnPlay.setBackground(new Color(55,55,55));
		btnPlay.setIcon(new ImageIcon(Inicio.class.getResource("/icons/Button-Play-icon.png")));
		btnPlay.setBounds(455, 20, 66, 50);
		panel_inferior.add(btnPlay);
		
		RSButtonMetro btnPause = new RSButtonMetro();
		btnPause.setColorHover(Color.DARK_GRAY);
		btnPause.setColorNormal(new Color(55,55,55));
		btnPause.setBackground(new Color(55,55,55));
		btnPause.setIcon(new ImageIcon(Inicio.class.getResource("/icons/Button-Pause-icon.png")));
		btnPause.setBounds(395, 20, 48, 50);
		panel_inferior.add(btnPause);
		panel.add(panel_izq);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 174, 376);
		panel_izq.add(panel_1);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);
		
		RSButtonMetro btnPlaylists = new RSButtonMetro();
		btnPlaylists.setBounds(0, 0, 174, 65);
		panel_1.add(btnPlaylists);
		btnPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel_1.setVisible(false);
				panel_playlist.setVisible(true);
				
				Animacion.Animacion.mover_izquierda(0, -188, 2, 2, panel_izq);
				
				try {
					Thread.sleep(150);
				}
				catch(InterruptedException e1){
					System.out.println("Thread Interrupted");
				}
				
				Animacion.Animacion.mover_derecha(-188, 0, 2, 2, panel_izq);
			}
		});
		btnPlaylists.setColorPressed(Color.LIGHT_GRAY);
		btnPlaylists.setColorHover(Color.GRAY);
		btnPlaylists.setText("Playlists");
		btnPlaylists.setColorNormal(Color.DARK_GRAY);
		btnPlaylists.setForeground(Color.WHITE);
		btnPlaylists.setBackground(Color.DARK_GRAY);
		
		panel_playlist = new JPanel();
		panel_playlist.setBounds(0, 0, 174, 376);
		panel_izq.add(panel_playlist);
		panel_playlist.setLayout(null);
		panel_playlist.setBackground(Color.DARK_GRAY);
		panel_playlist.setVisible(false);
		
		RSButtonMetro btnCrearPlaylist = new RSButtonMetro();
		btnCrearPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(null,"Introduzca el nombre de playlist: ","Playlist",JOptionPane.INFORMATION_MESSAGE);;
			}
		});
		btnCrearPlaylist.setText("Crear playlist");
		btnCrearPlaylist.setForeground(Color.WHITE);
		btnCrearPlaylist.setColorPressed(Color.LIGHT_GRAY);
		btnCrearPlaylist.setColorNormal(Color.DARK_GRAY);
		btnCrearPlaylist.setColorHover(Color.GRAY);
		btnCrearPlaylist.setBackground(Color.DARK_GRAY);
		btnCrearPlaylist.setBounds(0, 70, 174, 65);
		panel_playlist.add(btnCrearPlaylist);
		
		RSButtonMetro btnAtras = new RSButtonMetro();
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_playlist.setVisible(false);
				panel_1.setVisible(true);
				
				Animacion.Animacion.mover_izquierda(0, -188, 2, 2, panel_izq);
				
				try {
					Thread.sleep(150);
				}
				catch(InterruptedException e1){
					System.out.println("Thread Interrupted");
				}
				
				Animacion.Animacion.mover_derecha(-188, 0, 2, 2, panel_izq);
			}
		});
		btnAtras.setText("<- Atr\u00E1s");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setColorPressed(Color.LIGHT_GRAY);
		btnAtras.setColorNormal(Color.DARK_GRAY);
		btnAtras.setColorHover(Color.GRAY);
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setBounds(0, 0, 174, 65);
		panel_playlist.add(btnAtras);
		
		RSButtonMetro btnCargarPlaylist = new RSButtonMetro();
		btnCargarPlaylist.setText("Listar playlists");
		btnCargarPlaylist.setForeground(Color.WHITE);
		btnCargarPlaylist.setColorPressed(Color.LIGHT_GRAY);
		btnCargarPlaylist.setColorNormal(Color.DARK_GRAY);
		btnCargarPlaylist.setColorHover(Color.GRAY);
		btnCargarPlaylist.setBackground(Color.DARK_GRAY);
		btnCargarPlaylist.setBounds(0, 147, 174, 65);
		panel_playlist.add(btnCargarPlaylist);
		panel.add(panel_der);
		panel.add(panel_central);
	}
}
>>>>>>> branch 'master' of https://github.com/waterpolord/ProyectofinalBD2.git
