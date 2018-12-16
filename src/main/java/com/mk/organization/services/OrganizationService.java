package com.mk.organization.services;

import com.mk.organization.model.Organization;
import com.mk.organization.repository.OrganizationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository orgRepository;

    public Organization getOrg(String organizationId) {
    	System.out.println("OrganizationService old server call start");
    	Organization organization=null;
    	//randomlyRunLong();
    	System.out.println("OrganizationService old server call end");
    	organization=orgRepository.findById(organizationId);
    	organization.setContactName("OLD::"+organization.getContactName());
    	return organization;
    }
    
    public List<Organization> getOrgs() {
        return orgRepository.findAll();
    }
    
    
    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());

        orgRepository.save(org);

    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
        orgRepository.delete( org.getId());
    }
    
    private void randomlyRunLong(){
        Random rand = new Random();

        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        if (randomNum==3) sleep();
      }

      private void sleep(){
          try {
              Thread.sleep(12000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      } 
}
