package com.medavie.bluecross.tech.enums;

public enum SpeedState {
	
	OFF(0),  	// 0
	LOW(1), 	// 1
	MEDIUM(2), 	// 2
	HIGH(3); 	// 3
	
	private final int level;
	
	SpeedState(int level) {
		this.level = level;
	}

	
	public SpeedState getNextMode() {
        return values()[(ordinal()+1) % values().length];
    }
    public SpeedState getPreviousMode() {
        int totalModes = values().length ;
        return values()[(((ordinal()-1) % totalModes + values().length ) % values().length) ];
    }

}
