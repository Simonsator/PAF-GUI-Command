package de.simonsator.partyandfriends.extensions.guicommand;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.api.friends.abstractcommands.GUIOpeningFriendCommand;
import de.simonsator.partyandfriends.api.gui.MenuOpeningSpigotCommunicationTask;
import de.simonsator.partyandfriends.api.party.abstractcommands.GUIOpeningPartyCommand;
import de.simonsator.partyandfriends.communication.SpigotMessage;
import de.simonsator.partyandfriends.communication.communicationtasks.gui.OpenFriendRequestMenu;
import de.simonsator.partyandfriends.communication.communicationtasks.gui.OpenHideMenu;
import de.simonsator.partyandfriends.communication.communicationtasks.gui.OpenMainMenu;
import de.simonsator.partyandfriends.communication.communicationtasks.gui.OpenSettingsMenu;
import de.simonsator.partyandfriends.communication.communicationtasks.gui.party.OpenPartyMenu;
import de.simonsator.partyandfriends.extensions.guicommand.configuration.GCConfig;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.party.command.PartyCommand;

import java.io.File;
import java.io.IOException;

public class GCPlugin extends PAFExtension {
	private GCConfig config;
	private Friends friendsCommand;
	private PartyCommand partyCommand;

	@Override
	public void onEnable() {
		try {
			config = new GCConfig(new File(getConfigFolder(), "config.yml"), this, true);
			friendsCommand = Friends.getInstance();
			registerFriendGUICommand("FriendListGUI", OpenMainMenu.class);
			registerFriendGUICommand("SettingsGUI", OpenSettingsMenu.class);
			registerFriendGUICommand("FriendRequestGUI", OpenFriendRequestMenu.class);
			registerFriendGUICommand("HideGUI", OpenHideMenu.class);
			partyCommand = PartyCommand.getInstance();
			registerPartyGUICommand("PartyGUI", OpenPartyMenu.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void registerFriendGUICommand(String pCommandConfigName, Class<? extends MenuOpeningSpigotCommunicationTask> pClass) {
		if (config.getBoolean("Commands.Friends." + pCommandConfigName + ".Enabled")) {
			MenuOpeningSpigotCommunicationTask menu = (MenuOpeningSpigotCommunicationTask) SpigotMessage.getInstance().getTask(pClass);
			if (menu != null)
				friendsCommand.addCommand(
						new GUIOpeningFriendCommand(config.getStringList("Commands.Friends." + pCommandConfigName + ".Names"),
								config.getInt("Commands.Friends." + pCommandConfigName + ".Priority"),
								config.getString("Commands.Friends." + pCommandConfigName + ".CommandUsageMessage"),
								config.getString("Commands.Friends." + pCommandConfigName + ".Permission"), menu));
		}
	}

	private void registerPartyGUICommand(String pCommandConfigName, Class<? extends MenuOpeningSpigotCommunicationTask> pClass) {
		if (config.getBoolean("Commands.Party." + pCommandConfigName + ".Enabled")) {
			MenuOpeningSpigotCommunicationTask menu = (MenuOpeningSpigotCommunicationTask) SpigotMessage.getInstance().getTask(pClass);
			if (menu != null)
				partyCommand.addCommand(
						new GUIOpeningPartyCommand(config.getStringList("Commands.Party." + pCommandConfigName + ".Names"),
								config.getInt("Commands.Party." + pCommandConfigName + ".Priority"),
								config.getString("Commands.Party." + pCommandConfigName + ".CommandUsageMessage"),
								config.getString("Commands.Party." + pCommandConfigName + ".Permission"), menu));
		}
	}

}
