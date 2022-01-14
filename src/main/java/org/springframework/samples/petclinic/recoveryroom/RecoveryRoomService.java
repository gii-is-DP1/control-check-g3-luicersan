package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService{
	
	@Autowired
	RecoveryRoomRepository recoveryRoomRepository;
	
    public List<RecoveryRoom> getAll(){
    	return recoveryRoomRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
    	List<RecoveryRoomType> allRrTypes = recoveryRoomRepository.findAllRecoveryRoomTypes();
        return allRrTypes;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
    	RecoveryRoomType rrType = recoveryRoomRepository.getRecoveryRoomType(typeName);
        return rrType;
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
    	List<RecoveryRoom> biggerThan = this.recoveryRoomRepository.findBySizeMoreThan(size);
        return biggerThan;
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return null;       
    }

    
}
