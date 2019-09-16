package net.lightshard.versionframework;

import org.bukkit.Bukkit;

public enum Version
{
    VERSION_1_8("1.8", "Bountiful Update"),
    VERSION_1_9("1.9", "Combat Update"),
    VERSION_1_10("1.10", "Frostburn Update"),
    VERSION_1_11("1.11", "Exploration Update"),
    VERSION_1_12("1.12", "World of Color Update"),
    VERSION_1_13("1.13", "Aquatic Update"),
    VERSION_1_14("1.14", "Village Pillage Update"),
    UNKNOWN("Unknown", "Unknown");

    //////////////////////////////////////////////////
    ///  MEMBERS
    private static Version serverVersion;
    private final String versionNumber;
    private final String updateName;

    //////////////////////////////////////////////////
    /// CONSTRUCTORS

    Version(String versionNumber, String updateName)
    {
        this.versionNumber = versionNumber;
        this.updateName = updateName;
    }

    //////////////////////////////////////////////////
    /// GETTERS & SETTERS

    public static Version getServerVersion()
    {
        if (serverVersion == null)
        {
            String bukkitVersion = Bukkit.getVersion().toLowerCase();
            serverVersion = UNKNOWN;
            for (Version version : values())
            {
                if (bukkitVersion.contains(version.versionNumber))
                {
                    serverVersion = version;
                    break;
                }
            }
        }
        return serverVersion;
    }

    public String getUpdateName()
    {
        return updateName;
    }
}
