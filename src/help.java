Aggregation usually requires the use of arrays to store references to other objects. For starting on this look at both the Object relationship video (chapter 6) and the dynamic arrays video.
Although you don't need to use this I am going to include a sample of my pseudocode of the driver to give you some direction on what you will need to do once you setup all the objects:
      public static void driver()
      {
            int hour = 0;
            while (Cargo.isActiveCargo())
            {
                  //update any moving vehicles
                        //transitTime-- esentially, if transitTime <= 0 thenwe reached our next stop along the path
                        //if vehicles have reached the next stop in the path then
                              //pop the site of the path list
                              //if the cargo is at its destination then drop it off (if pathlist.isEmpty())
                                    //remove the cargo from the array of active cargo
                              //see if this vehicle can continue the trip
                                    //then move to the next hop
                                          //set the vehicle to by "in transit" and set vehicle transit time to the time in the route
                              //If the vehicle can't continue (owned by another company and maybe they have a waiting vehicle)
                                    //then drop off the cargo and return to an owned site, or travel to the next available cargo
                                          //note also see if there is any cargo at this site going to your next destination (see if the site owner wants you to take it)
                             
                 
                  //go through the cargo list and activate any that are less than or equal to the time
                  //for each active cargo get the site's company at the source and tell it to dispatch a vehicle to the location (if one is not already there)
                 
            }
            //print output which includes
                  //company total earnings, numbers of cargo moved...         
      }