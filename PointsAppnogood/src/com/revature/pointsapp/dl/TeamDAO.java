package com.revature.pointsapp.dl;

import com.revature.pointsapp.models.Team;
import com.revature.pointsapp.storage.TempStorage;
import com.revature.pointsapp.util.Logger;
import com.revature.pointsapp.util.Logger.LogLevel;

public class TeamDAO implements DAO<Team> {
	private static Logger logger = Logger.getLogger();

	@Override
	public void addInstance(Team newInstance) {
		// TODO Auto-generated method stub
		// to add a team somewhere I need a place to store it
		TempStorage.teams.add(newInstance);
		logger.log(LogLevel.info, "Adding a new team with name "+ newInstance.getTeamName());
	}

	@Override
	public Team getByName(String name) {
		// TODO Auto-generated method stub
		for(Team team : getAll()) {
			if(team.getTeamName().equals(name)) {
				logger.log(LogLevel.info, "Team " + name + " found!");
				return team;
			} 
		}
		logger.log(LogLevel.warning, "Team " + name + " not found!");
		return null;
	}

	@Override
	public Team[] getAll() {
		// TODO Auto-generated method stub
		logger.log(LogLevel.info, "Getting all teams");
		return TempStorage.teams.getAllElements();
	}

	@Override
	public void updateInstance(Team updatedInstance) {
		// TODO Auto-generated method stub
		Team[] allTeams = getAll();
		for(int i = 0; i < allTeams.length; i++)
		{
			if(allTeams[i].getTeamName().equals(updatedInstance.getTeamName())) {
				allTeams[i] = updatedInstance;
				logger.log(LogLevel.info, "Team "+updatedInstance.getTeamName()+ " successfully updated!");
				break;
			}
		}
	}
	

}
