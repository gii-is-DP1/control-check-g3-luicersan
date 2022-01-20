package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService{
	
	@Autowired
	private RecoveryRoomRepository recoveryRoomRepository;
	
	public List<RecoveryRoom> getAll(){
		List<RecoveryRoom> allRr = recoveryRoomRepository.findAll();
        return allRr;
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
    	List<RecoveryRoom> rrBiggerThan = this.recoveryRoomRepository.findBySizeMoreThan(size);
    	return rrBiggerThan;
    }

    public RecoveryRoom save(RecoveryRoom rr) {
        return recoveryRoomRepository.save(rr);       
    }
	/*
    public List<RecoveryRoom> getAll(){
    	return recoveryRoomRepository.findAll();
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
    
    */

    
}
