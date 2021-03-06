package ch.hearc.meteo.imp.afficheur.real.vue.layout;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;

import ch.hearc.meteo.imp.afficheur.simulateur.moo.AfficheurServiceMOO;
import ch.hearc.meteo.spec.com.meteo.MeteoServiceOptions;

public class JFrameStationMeteoCentral extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameStationMeteoCentral(AfficheurServiceMOO afficheurServiceMOO)
		{
		this.afficheurServiceMOO = afficheurServiceMOO;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void refresh()
		{
		jpanelstationmeteocentral.refresh();
		}

	public void updateMeteoServiceOptions(MeteoServiceOptions meteoServiceOptions)
		{
		jpanelstationmeteocentral.updateMeteoServiceOptions(meteoServiceOptions);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
			// JComponent : Instanciation
			jpanelstationmeteocentral = new JPanelStationMeteoCentral(afficheurServiceMOO);

			// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);
			}

			// JComponent : add
			add(jpanelstationmeteocentral, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 400);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	public void addStation(String nom, JPanelStationMeteo jpanel)
		{
		jpanelstationmeteocentral.addStation(nom, jpanel);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelStationMeteoCentral jpanelstationmeteocentral;

	// Inputs
	private AfficheurServiceMOO afficheurServiceMOO;

	}
