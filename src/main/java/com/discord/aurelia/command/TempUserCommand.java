package com.discord.aurelia.command;

import java.util.HashMap;
import java.util.Map;

public class TempUserCommand {
    
    private Map<String,String> properties;
    private int maxProp;
    private int currentProp;
    private Long timeToLive;

    public TempUserCommand(Map<String, String> properties, int maxProp, Long timeToLive) {
        this.properties = properties;
        this.maxProp = maxProp;
        this.timeToLive = timeToLive;
        this.currentProp=0;
    }
public TempUserCommand(){
    properties= new HashMap<>();

}
public void addProp (String key,String value){
    if(maxProp==currentProp){
        return;
    }
    properties.put(key, value);
    currentProp++;
}
    public Map<String, String> getProperties() {
        return properties;
    }

    public int getMaxProp() {
        return maxProp;
    }

    public void setMaxProp(int maxProp) {
        this.maxProp = maxProp;
    }

    public Long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Long timeToLive) {
        this.timeToLive = timeToLive;
    }

    @Override
    public String toString() {
        return "TempUserCommand [maxProp=" + maxProp + ", properties=" + properties + ", timeToLive=" + timeToLive
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maxProp;
        result = prime * result + ((properties == null) ? 0 : properties.hashCode());
        result = prime * result + ((timeToLive == null) ? 0 : timeToLive.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TempUserCommand other = (TempUserCommand) obj;
        if (maxProp != other.maxProp)
            return false;
        if (properties == null) {
            if (other.properties != null)
                return false;
        } else if (!properties.equals(other.properties))
            return false;
        if (timeToLive == null) {
            if (other.timeToLive != null)
                return false;
        } else if (!timeToLive.equals(other.timeToLive))
            return false;
        return true;
    }

   

}
