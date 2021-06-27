package com.concert.model;

public class Info {

	/**
	 * <pre>
	 * 공연 정보 도메인 클래스 
	 * ## 회원 검증조건
	 * 1. 공연코드
	 * 2. 공연이름
	 * 3. 공연날짜
	 * 4. 공연시간
	 * 5. 여자배우
	 * 6. 남자배우
	 * 7. 티켓가격
	 * </pre>
	 * @author 유준성
	 * @version ver.1.0
	 * @since jdk1.8
	 */

		/** 공연코드 : 식별키 */
		public String infoCode;
		
		/** 공연이름 : 필수 */
		public String infoName;
		
		/** 공연날짜 : 필수 */
		public String infoDate;
		
		/** 공연시간 : 필수 */
		public String infoTime;
		
		/** 여자배우 : 필수 */
		public String infoFemaleActor;
		
		/** 남자배우 : 필수 */
		public String infoMaleActor;
		
		/** 티켓가격 : 필수 */
		public int ticketPrice;

		/**
		 * 
		 */
		public Info() {
		}

		/**
		 * @param infoCode
		 * @param infoName
		 * @param infoDate
		 * @param infoTime
		 * @param infoFemaleActor
		 * @param infoMaleActor
		 * @param ticketPrice
		 */
		public Info(String infoCode, String infoName, String infoDate, String infoTime, String infoFemaleActor,
				String infoMaleActor, int ticketPrice) {
			this.infoCode = infoCode;
			this.infoName = infoName;
			this.infoDate = infoDate;
			this.infoTime = infoTime;
			this.infoFemaleActor = infoFemaleActor;
			this.infoMaleActor = infoMaleActor;
			this.ticketPrice = ticketPrice;
		}

		/**
		 * @return the infoCode
		 */
		public String getInfoCode() {
			return infoCode;
		}

		/**
		 * @param infoCode the infoCode to set
		 */
		public void setInfoCode(String infoCode) {
			this.infoCode = infoCode;
		}

		/**
		 * @return the infoName
		 */
		public String getInfoName() {
			return infoName;
		}

		/**
		 * @param infoName the infoName to set
		 */
		public void setInfoName(String infoName) {
			this.infoName = infoName;
		}

		/**
		 * @return the infoDate
		 */
		public String getInfoDate() {
			return infoDate;
		}

		/**
		 * @param infoDate the infoDate to set
		 */
		public void setInfoDate(String infoDate) {
			this.infoDate = infoDate;
		}

		/**
		 * @return the infoTime
		 */
		public String getInfoTime() {
			return infoTime;
		}

		/**
		 * @param infoTime the infoTime to set
		 */
		public void setInfoTime(String infoTime) {
			this.infoTime = infoTime;
		}

		/**
		 * @return the infoFemaleActor
		 */
		public String getInfoFemaleActor() {
			return infoFemaleActor;
		}

		/**
		 * @param infoFemaleActor the infoFemaleActor to set
		 */
		public void setInfoFemaleActor(String infoFemaleActor) {
			this.infoFemaleActor = infoFemaleActor;
		}

		/**
		 * @return the infoMaleActor
		 */
		public String getInfoMaleActor() {
			return infoMaleActor;
		}

		/**
		 * @param infoMaleActor the infoMaleActor to set
		 */
		public void setInfoMaleActor(String infoMaleActor) {
			this.infoMaleActor = infoMaleActor;
		}

		/**
		 * @return the ticketPrice
		 */
		public int getTicketPrice() {
			return ticketPrice;
		}

		/**
		 * @param ticketPrice the ticketPrice to set
		 */
		public void setTicketPrice(int ticketPrice) {
			this.ticketPrice = ticketPrice;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((infoCode == null) ? 0 : infoCode.hashCode());
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
			Info other = (Info) obj;
			if (infoCode == null) {
				if (other.infoCode != null)
					return false;
			} else if (!infoCode.equals(other.infoCode))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(infoCode);
			builder.append(", ");
			builder.append(infoName);
			builder.append(", ");
			builder.append(infoDate);
			builder.append(", ");
			builder.append(infoTime);
			builder.append(", ");
			builder.append(infoFemaleActor);
			builder.append(", ");
			builder.append(infoMaleActor);
			builder.append(", ");
			builder.append(ticketPrice);
			return builder.toString();
		}

	

	
	
	
}
