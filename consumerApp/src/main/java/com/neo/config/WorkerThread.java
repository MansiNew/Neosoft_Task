package com.neo.config;

public class WorkerThread implements Runnable {

	 private String msg;
	    
	    public WorkerThread(String s){
	        this.msg=s;
	    }
	    @Override
	    public void run() {
	        System.out.println(Thread.currentThread().getName()+" Start. Command = "+msg);
	        processCommand();
	        System.out.println(Thread.currentThread().getName()+" End.");
	    }

	    private void processCommand() {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public String toString(){
	        return this.msg;
	    }
	}

