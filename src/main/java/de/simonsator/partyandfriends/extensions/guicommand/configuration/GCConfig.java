package de.simonsator.partyandfriends.extensions.guicommand.configuration;

import de.simonsator.partyandfriends.api.PAFPluginBase;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class GCConfig extends ConfigurationCreator {
	public GCConfig(File file, PAFPluginBase pPlugin, boolean supportHexColors) throws IOException {
		super(file, pPlugin, supportHexColors);
		readFile();
		loadDefaultValues();
		saveFile();
		process();
	}

	private void loadDefaultValues() {
		set("Commands.Friends.FriendListGUI.Enabled", true);
		set("Commands.Friends.FriendListGUI.Names", "listgui", "guilist");
		set("Commands.Friends.FriendListGUI.Permission", "");
		set("Commands.Friends.FriendListGUI.Priority", 3);
		set("Commands.Friends.FriendListGUI.CommandUsageMessage", "&8/&5friend guilist &8- &7Lists all your friends");
		set("Commands.Friends.SettingsGUI.Enabled", true);
		set("Commands.Friends.SettingsGUI.Names", "settingsgui", "guisettings");
		set("Commands.Friends.SettingsGUI.Permission", "");
		set("Commands.Friends.SettingsGUI.Priority", 4);
		set("Commands.Friends.SettingsGUI.CommandUsageMessage", "&8/&5friend settingsgui &8- &7Change the settings");
		set("Commands.Friends.FriendRequestGUI.Enabled", true);
		set("Commands.Friends.FriendRequestGUI.Names", "requestgui", "guirequest");
		set("Commands.Friends.FriendRequestGUI.Permission", "");
		set("Commands.Friends.FriendRequestGUI.Priority", 5);
		set("Commands.Friends.FriendRequestGUI.CommandUsageMessage", "&8/&5friend requestgui &8- &7Lists all your friend requests");
		set("Commands.Friends.HideGUI.Enabled", true);
		set("Commands.Friends.HideGUI.Names", "hidegui", "guihide");
		set("Commands.Friends.HideGUI.Permission", "");
		set("Commands.Friends.HideGUI.Priority", 6);
		set("Commands.Friends.FriendRequestGUI.CommandUsageMessage", "&8/&5friend hidegui &8- &7Opens the hide gui");
		set("Commands.Friends.HideGUI.CommandUsageMessage", "&8/&5friend hidegui &8- &7Opens the hide gui");
		set("Commands.Party.PartyGUI.Enabled", true);
		set("Commands.Party.PartyGUI.Names", "partygui", "guiparty");
		set("Commands.Party.PartyGUI.Permission", "");
		set("Commands.Party.PartyGUI.Priority", 3);
		set("Commands.Party.PartyGUI.CommandUsageMessage", "&8/&5Party listgui &8- &7List all players who are in the party");

	}
}
