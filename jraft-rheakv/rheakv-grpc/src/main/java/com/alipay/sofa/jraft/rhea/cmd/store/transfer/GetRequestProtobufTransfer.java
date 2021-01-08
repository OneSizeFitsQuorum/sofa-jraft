/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.jraft.rhea.cmd.store.transfer;

import com.alipay.sofa.jraft.rhea.cmd.store.GetRequest;
import com.alipay.sofa.jraft.rhea.cmd.store.proto.RheakvRpc;
import com.alipay.sofa.jraft.rpc.impl.GrpcSerializationTransfer;
import com.google.protobuf.ByteString;

/**
 * @author: baozi
 */
public class GetRequestProtobufTransfer implements GrpcSerializationTransfer<GetRequest, RheakvRpc.GetRequest> {

    @Override
    public GetRequest protoBufTransJavaBean(final RheakvRpc.GetRequest getRequest) {
        final GetRequest request = new GetRequest();
        BaseRequestProtobufTransfer.protoBufTransJavaBean(request, getRequest.getBaseRequest());
        request.setKey(getRequest.getKey().toByteArray());
        request.setReadOnlySafe(getRequest.getReadOnlySafe());
        return request;
    }

    @Override
    public RheakvRpc.GetRequest javaBeanTransProtobufBean(final GetRequest getRequest) {
        return RheakvRpc.GetRequest.newBuilder()
            .setBaseRequest(BaseRequestProtobufTransfer.javaBeanTransProtobufBean(getRequest))
            .setKey(ByteString.copyFrom(getRequest.getKey())).setReadOnlySafe(getRequest.isReadOnlySafe()).build();
    }
}