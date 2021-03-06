
package ch.hearc.meteo.imp.afficheur.real.vue.layout;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import ch.hearc.meteo.imp.afficheur.simulateur.moo.AfficheurServiceMOO;
import ch.hearc.meteo.spec.com.meteo.MeteoServiceOptions;

public class JFrameStationMeteo extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameStationMeteo(AfficheurServiceMOO afficheurServiceMOO)
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
		jpanelstationmeteo.refresh();
		}

	public void setConnected(boolean b)
		{
		jpanelstationmeteo.setConnected(b);
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

	public void updateMeteoServiceOptions(MeteoServiceOptions meteoServiceOptions)
		{
		jpanelstationmeteo.updateMeteoServiceOptions(meteoServiceOptions);
		}

	private void geometry()
		{
		// JComponent : Instanciation
		jpanelstationmeteo = new JPanelStationMeteo(afficheurServiceMOO);

			// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);
			}

		// JComponent : add
		add(jpanelstationmeteo, BorderLayout.CENTER);
		}

	private void control()
		{
//		addWindowListener(new WindowAdapter()
//			{
//				@Override
//				public void windowClosing(WindowEvent we)
//					{
//					try
//						{
//						afficheurServiceMOO.getMeteoServiceRemote().disconnect();
//						afficheurServiceMOO.getMeteoServiceRemote().stop();
//						}
//					catch (RemoteException e)
//						{
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						}
//					catch (MeteoServiceException e)
//						{
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						}
//					//TODO A PROPER EXIT LINKED WITH CENTRAL PC HERE
//					}
//			});
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(800, 600);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	public JPanelStationMeteo getPanelStationMeteo()
		{
		return this.jpanelstationmeteo;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelStationMeteo jpanelstationmeteo;

	// Inputs
	private AfficheurServiceMOO afficheurServiceMOO;

	}
