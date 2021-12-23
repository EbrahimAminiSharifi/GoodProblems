/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.booking;

/**
 *
 * @author moghaleb
 */
//public class HotelLoggedInRate {

	//private static List<OutputMessage> getSolution(List<HotelViewEvent> events){

//		return events.stream()
//				.filter(event -> event.getLoggedIn())
//				.map(msg ->{
//					return new OutputMessage(msg.areaCode, msg.hotelId, 1);
//				})
//				.collect(Collectors.groupingBy(oMsg -> oMsg.hotel_area_code+"_"+oMsg.hotel_id))
//				.entrySet()
//				.stream()
//				.map(entry -> {
//					String key = entry.getKey();
//					String[] keyData = key.split("_");
//					String hotelID = keyData[1];
//					String areaCode = keyData[0];
//					List<OutputMessage> hData = entry.getValue();
//					OutputMessage hDataMsg = hData.stream().reduce(new OutputMessage(areaCode, Long.parseLong(hotelID), 0), (a,b) -> {
//						a.views = a.views + b.views;
//						return a;
//					});
//					return hDataMsg;
//				})
//				.collect(Collectors.groupingBy(oMsg -> oMsg.hotel_area_code))
//				.values()
//				.stream()
//				.map(areaData -> {
//					areaData.sort((h1,h2)->(h2.views - h1.views));
//					return areaData.get(0);
//				})
//				.collect(Collectors.toList());
//	}
	
	//public static void main(String[] args) {
//		List<HotelViewEvent> list = new ArrayList<>();
//		
//		list.add(new HotelViewEvent(23, "IT", "user1", true));
//		list.add(new HotelViewEvent(23, "IT", "user2", true));
//		list.add(new HotelViewEvent(23, "IT", "user1", true));
//		list.add(new HotelViewEvent(24, "IT", "user1", true));
//		list.add(new HotelViewEvent(24, "IT", "user2", true));
//		list.add(new HotelViewEvent(24, "IT", "user1", true));
//		list.add(new HotelViewEvent(24, "IT", "user1", true));
//		list.add(new HotelViewEvent(35, "FR", "user1", true));
//		
//		System.out.println(getSolution(list));
	//}
//}
