package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjtu.dao.CarTeamDao;
import cn.edu.bjtu.service.CarTeamService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carteam;

@Service
public class CarTeamServiceImpl implements CarTeamService{
	
	@Autowired
	CarTeamDao carTeamDao;
	@Autowired
	Carteam carteam;

	@Override
	public List getCarteam(String carrierId) {
		// TODO Auto-generated method stub
		return carTeamDao.getCarteam(carrierId);
	}

	@Override
	public Carteam getCarteamInfo(String id) {
		// TODO Auto-generated method stub
		return carTeamDao.getCarteamInfo(id);
	}

	@Override
	public boolean insertCarteam(String teamName, String carCount,
			String chief, String phone, String explaination, String carrierId) {
		/*System.out.println("insertcarteam " + IdCreator.createCarteamId()
				+ teamName + carCount + carrierId + chief + phone
				+ explaination + new Date());// null
*/		carteam.setId(IdCreator.createCarteamId());
		carteam.setTeamName(teamName);
		carteam.setCarCount(carCount);
		carteam.setCarrierId(carrierId);
		carteam.setChief(chief);
		carteam.setPhone(phone);
		carteam.setExplaination(explaination);
		carteam.setRelDate(new Date());
		// return true;
		carTeamDao.save(carteam);// ����ʵ��
		return true;
	}

	@Override
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteCarteam(String id) {
		carteam = getCarteamInfo(id);// ����id���ҵ�������Ϣ
		carTeamDao.delete(carteam);
		return true;
	}

	@Override
	public boolean updateCarteam(String id, String teamName, String carCount,
			String chief, String phone, String explaination) {
		carteam = getCarteamInfo(id);// ����id���ҵ�������Ϣ
		carteam.setTeamName(teamName);
		carteam.setCarCount(carCount);
		carteam.setChief(chief);
		carteam.setPhone(phone);
		carteam.setExplaination(explaination);
		// return true;
		carTeamDao.update(carteam);// ����ʵ��
		return true;
	}
}