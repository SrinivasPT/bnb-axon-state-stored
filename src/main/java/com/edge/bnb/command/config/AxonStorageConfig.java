package com.edge.bnb.command.config;

import com.thoughtworks.xstream.XStream;
import org.axonframework.common.caching.Cache;
import org.axonframework.common.caching.WeakReferenceCache;
import org.axonframework.config.Configurer;
import org.axonframework.lifecycle.Phase;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.interceptors.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AxonStorageConfig {
    @Autowired
    public void configureLoggingInterceptor(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") Configurer configurer
    ) {
        LoggingInterceptor<Message<?>> loggingInterceptor = new LoggingInterceptor<>();

        // Registers the LoggingInterceptor on all infrastructure once they've been initialized by the Configurer:
        configurer.onInitialize(config ->
                config.onStart(Phase.INSTRUCTION_COMPONENTS + 1, () -> {
                    config.commandBus().registerHandlerInterceptor(loggingInterceptor);
                    config.commandBus().registerDispatchInterceptor(loggingInterceptor);
                    config.eventBus().registerDispatchInterceptor(loggingInterceptor);
                    config.queryBus().registerHandlerInterceptor(loggingInterceptor);
                    config.queryBus().registerDispatchInterceptor(loggingInterceptor);
                    config.queryUpdateEmitter().registerDispatchInterceptor(loggingInterceptor);
                }));

        // Registers a default Handler Interceptor for all Event Processors:
        configurer.eventProcessing()
                .registerDefaultHandlerInterceptor((config, processorName) -> loggingInterceptor);
    }

    @Bean
    @Profile("command")
    public Cache hotelCache() {
        return new WeakReferenceCache();
    }

    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();
        xStream.allowTypesByWildcard(new String[]{"com.edge.bnb.**"});
        return xStream;
    }
}
