package org.kaipan.www.socket.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import org.kaipan.www.socket.log.Logger;

public class SocketChannelClient implements Client
{
	private SocketChannel client;
	
	public SocketChannelClient() 
	{
		this.initialize(true);
	}
	
	public SocketChannelClient(boolean blocking) 
	{
		this.initialize(blocking);
	}

	private void initialize(boolean blocking) 
	{
		try {
			client = SocketChannel.open();
			client.configureBlocking(blocking);
		} 
		catch (IOException e) {
			Logger.write(e.getMessage(), Logger.ERROR);
		}
	}
	
	@Override
	public boolean connect(String host, int port)
	{
		InetSocketAddress address = new InetSocketAddress(host, port);
		
		try {
			return client.connect(address);
		} 
		catch (IOException e) {
			Logger.write(e.getMessage(), Logger.ERROR);
		}
		
		return false;
	}

	@Override
	public byte[] read()
	{
		return null;
	}

	@Override
	public boolean write(byte[] data)
	{
		return false;
	}

	@Override
	public boolean close()
	{
		return false;
	}
}