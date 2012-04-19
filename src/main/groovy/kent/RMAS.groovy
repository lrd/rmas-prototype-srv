package kent

// initialise db stuff to store messages


import groovyx.net.ws.WSServer

def server = new WSServer()

// rmas events go through this node
server.setNode('kent.services.EventService', 'http://129.12.9.208:6980/EventService')

println 'Starting server...'

server.start()
