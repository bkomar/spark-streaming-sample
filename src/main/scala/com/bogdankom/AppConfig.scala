package com.bogdankom

case class AppConfig(receiver: ReceiversConf)
case class ReceiversConf(socket: SocketConf, fs: FSConf)
case class SocketConf(host: String, port: Int)
case class FSConf(input: String)
