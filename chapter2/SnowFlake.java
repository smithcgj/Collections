package chapter2;


public class SnowFlake {
	/**
	 * 起始的时间戳
	 */
	private final static long START_TIMESTAMP = 1480166465631L;
	/**
	 * 每一部分占用的位数
	 */
	private final static long SEQUENCE_BIT = 12;
	private final static long MACHINE_BIT = 5;
	private final static long DATA_CENTER_BIT = 5;
	/**
	 * 每一部分的最大值
	 */
	private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
	private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
	private final static long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);
	
	/**
	 *每一部分向左的位移
	 */
	private final static long MACHINE_LEFT = SEQUENCE_BIT;
	private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
	private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;
	
	private long dataCenterId;//数据中心
	private long machineId;//机器标识
	private long sequence = 0L;//序列号
	private long lastTimeStamp = -1L;//上一次的时间戳
	
	/**
	 * 根据指定的数据中心ID和机器标志ID生成指定的序列号
	 * @param dataCenterId 数据中心ID
	 * @param machineId 机器标志ID
	 */
	public SnowFlake(long dataCenterId , long machineId) {
		if(dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
			throw new IllegalArgumentException("DataCenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0");
		}
		if(machineId > MAX_MACHINE_NUM || machineId < 0 ) {
			throw new IllegalArgumentException("MachineId can't be greater than MAX_CHINE_NUM or less than 0!");
		}
		this.machineId=machineId;
		this.dataCenterId=dataCenterId;
	}
	/**
	 * 产生下一个ID
	 * @return
	 */
	public synchronized long nextId() {
		long currTimeStamp = getNewTimeStamp();
		if(currTimeStamp < lastTimeStamp) {
			throw new RuntimeException("Clock moved backwards. Refusing to generate id");
		}
		if(currTimeStamp == lastTimeStamp) {
			//相同毫秒内，序列号自增
			sequence = (sequence + 1) & MAX_SEQUENCE;
			//同一毫秒的系列数已经达到最大
			if(sequence == 0L) {
				currTimeStamp = getNextMill();
			}
		}else {
			//不同毫秒内，序列号置为0
			sequence = 0L;
		}
		lastTimeStamp = currTimeStamp;
		return (currTimeStamp - START_TIMESTAMP) << TIMESTAMP_LEFT  //时间戳部分
				| dataCenterId << DATA_CENTER_LEFT //数据中心部分
				| machineId << MACHINE_LEFT //机器标识部分
				| sequence;
	}
	
	private long getNextMill() {
		long mill = getNewTimeStamp();
		while(mill <= lastTimeStamp) {
			mill = getNewTimeStamp();
		}
		return mill;
	}
	
	private long getNewTimeStamp() {
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnowFlake sFlake =new SnowFlake(2, 3);
		for(int i=0;i<(1 << 4); i++) {
			System.out.println(sFlake.nextId());
		}

	}

}
