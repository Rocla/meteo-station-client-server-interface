
package ch.hearc.meteo.imp.afficheur.real.vue.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ch.hearc.meteo.imp.afficheur.simulateur.moo.AfficheurServiceMOO;
import ch.hearc.meteo.spec.com.meteo.MeteoServiceOptions;

public class JPanelStationMeteoCentral extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelStationMeteoCentral(AfficheurServiceMOO afficheurServiceMOO)
		{
		this.afficheurServiceMOO = afficheurServiceMOO;
		nb = 0;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/


	public void refresh()
		{
		mapStation.get(jlistStation.getSelectedValue()).refresh();
		}

	public void updateMeteoServiceOptions(MeteoServiceOptions meteoServiceOptions)
		{
		mapStation.get(jlistStation.getSelectedValue()).updateMeteoServiceOptions(meteoServiceOptions);
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
		mapStation = new HashMap<String, JPanelStationMeteo>();
		listModel = new DefaultListModel<Object>();

		jlistStation = new JList<Object>(listModel);
		jlistStation.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlistStation.setLayoutOrientation(JList.VERTICAL);
		jlistStation.setVisibleRowCount(-1);
		jlistStation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlistStation.addListSelectionListener(new ListSelectionListener()
			{
				@Override
				public void valueChanged(ListSelectionEvent le)
					{
					int idx = jlistStation.getSelectedIndex();
					if (idx != -1)
						{
						Object[] tab = mapStation.keySet().toArray();
						for(JPanelStationMeteo element : mapStation.values())
							{
							element.setVisible(false);
							}
						mapStation.get(tab[idx]).setVisible(true);
						revalidate();
						}
					}
			});

		JScrollPane listScroller = new JScrollPane(jlistStation);
		listScroller.setPreferredSize(new Dimension(250, 80));
			// Layout : Specification
			{
			BorderLayout layout = new BorderLayout();
			setLayout(layout);

			add(listScroller, BorderLayout.WEST);
			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	public void addStation(String nom, JPanelStationMeteo jpanel)
		{
		nb++;
		String name = nb+". "+nom;
		mapStation.put(name,jpanel);
		listModel.addElement(name);

		jpanel.setVisible(false);
		add(mapStation.get(name), BorderLayout.CENTER);

		updateUI();
		revalidate();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JList<Object> jlistStation;
	private Map<String, JPanelStationMeteo> mapStation;

	private DefaultListModel<Object> listModel;

	// Inputs
	private AfficheurServiceMOO afficheurServiceMOO;

	private static int nb;

	}
