/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceCall;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.cdn.ErrorResponseException;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Origins.
 */
public final class OriginsInner {
    /** The Retrofit service to perform REST calls. */
    private OriginsService service;
    /** The service client containing this operation class. */
    private CdnManagementClientImpl client;

    /**
     * Initializes an instance of OriginsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public OriginsInner(Retrofit retrofit, CdnManagementClientImpl client) {
        this.service = retrofit.create(OriginsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Origins to be
     * used by Retrofit to perform actually REST calls.
     */
    interface OriginsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Cdn/profiles/{profileName}/endpoints/{endpointName}/origins")
        Observable<Response<ResponseBody>> listByEndpoint(@Path("resourceGroupName") String resourceGroupName, @Path("profileName") String profileName, @Path("endpointName") String endpointName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Cdn/profiles/{profileName}/endpoints/{endpointName}/origins/{originName}")
        Observable<Response<ResponseBody>> get(@Path("resourceGroupName") String resourceGroupName, @Path("profileName") String profileName, @Path("endpointName") String endpointName, @Path("originName") String originName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PATCH("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Cdn/profiles/{profileName}/endpoints/{endpointName}/origins/{originName}")
        Observable<Response<ResponseBody>> update(@Path("resourceGroupName") String resourceGroupName, @Path("profileName") String profileName, @Path("endpointName") String endpointName, @Path("originName") String originName, @Path("subscriptionId") String subscriptionId, @Body OriginUpdateParametersInner originUpdateProperties, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PATCH("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Cdn/profiles/{profileName}/endpoints/{endpointName}/origins/{originName}")
        Observable<Response<ResponseBody>> beginUpdate(@Path("resourceGroupName") String resourceGroupName, @Path("profileName") String profileName, @Path("endpointName") String endpointName, @Path("originName") String originName, @Path("subscriptionId") String subscriptionId, @Body OriginUpdateParametersInner originUpdateProperties, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("{nextLink}")
        Observable<Response<ResponseBody>> listByEndpointNext(@Path(value = "nextLink", encoded = true) String nextPageLink, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @return the PagedList&lt;OriginInner&gt; object if successful.
     */
    public PagedList<OriginInner> listByEndpoint(final String resourceGroupName, final String profileName, final String endpointName) {
        ServiceResponse<Page<OriginInner>> response = listByEndpointSinglePageAsync(resourceGroupName, profileName, endpointName).toBlocking().single();
        return new PagedList<OriginInner>(response.getBody()) {
            @Override
            public Page<OriginInner> nextPage(String nextPageLink) {
                return listByEndpointNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<OriginInner>> listByEndpointAsync(final String resourceGroupName, final String profileName, final String endpointName, final ListOperationCallback<OriginInner> serviceCallback) {
        return AzureServiceCall.create(
            listByEndpointSinglePageAsync(resourceGroupName, profileName, endpointName),
            new Func1<String, Observable<ServiceResponse<Page<OriginInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OriginInner>>> call(String nextPageLink) {
                    return listByEndpointNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @return the observable to the PagedList&lt;OriginInner&gt; object
     */
    public Observable<Page<OriginInner>> listByEndpointAsync(final String resourceGroupName, final String profileName, final String endpointName) {
        return listByEndpointWithServiceResponseAsync(resourceGroupName, profileName, endpointName)
            .map(new Func1<ServiceResponse<Page<OriginInner>>, Page<OriginInner>>() {
                @Override
                public Page<OriginInner> call(ServiceResponse<Page<OriginInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @return the observable to the PagedList&lt;OriginInner&gt; object
     */
    public Observable<ServiceResponse<Page<OriginInner>>> listByEndpointWithServiceResponseAsync(final String resourceGroupName, final String profileName, final String endpointName) {
        return listByEndpointSinglePageAsync(resourceGroupName, profileName, endpointName)
            .concatMap(new Func1<ServiceResponse<Page<OriginInner>>, Observable<ServiceResponse<Page<OriginInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OriginInner>>> call(ServiceResponse<Page<OriginInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByEndpointNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
    ServiceResponse<PageImpl<OriginInner>> * @param resourceGroupName Name of the Resource group within the Azure subscription.
    ServiceResponse<PageImpl<OriginInner>> * @param profileName Name of the CDN profile which is unique within the resource group.
    ServiceResponse<PageImpl<OriginInner>> * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @return the PagedList&lt;OriginInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<OriginInner>>> listByEndpointSinglePageAsync(final String resourceGroupName, final String profileName, final String endpointName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (profileName == null) {
            throw new IllegalArgumentException("Parameter profileName is required and cannot be null.");
        }
        if (endpointName == null) {
            throw new IllegalArgumentException("Parameter endpointName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.listByEndpoint(resourceGroupName, profileName, endpointName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<OriginInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OriginInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<OriginInner>> result = listByEndpointDelegate(response);
                        return Observable.just(new ServiceResponse<Page<OriginInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<OriginInner>> listByEndpointDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<OriginInner>, ErrorResponseException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<OriginInner>>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Gets an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @return the OriginInner object if successful.
     */
    public OriginInner get(String resourceGroupName, String profileName, String endpointName, String originName) {
        return getWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName).toBlocking().single().getBody();
    }

    /**
     * Gets an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<OriginInner> getAsync(String resourceGroupName, String profileName, String endpointName, String originName, final ServiceCallback<OriginInner> serviceCallback) {
        return ServiceCall.create(getWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName), serviceCallback);
    }

    /**
     * Gets an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @return the observable to the OriginInner object
     */
    public Observable<OriginInner> getAsync(String resourceGroupName, String profileName, String endpointName, String originName) {
        return getWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName).map(new Func1<ServiceResponse<OriginInner>, OriginInner>() {
            @Override
            public OriginInner call(ServiceResponse<OriginInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Gets an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @return the observable to the OriginInner object
     */
    public Observable<ServiceResponse<OriginInner>> getWithServiceResponseAsync(String resourceGroupName, String profileName, String endpointName, String originName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (profileName == null) {
            throw new IllegalArgumentException("Parameter profileName is required and cannot be null.");
        }
        if (endpointName == null) {
            throw new IllegalArgumentException("Parameter endpointName is required and cannot be null.");
        }
        if (originName == null) {
            throw new IllegalArgumentException("Parameter originName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(resourceGroupName, profileName, endpointName, originName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<OriginInner>>>() {
                @Override
                public Observable<ServiceResponse<OriginInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<OriginInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<OriginInner> getDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<OriginInner, ErrorResponseException>(this.client.mapperAdapter())
                .register(200, new TypeToken<OriginInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Updates an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param originUpdateProperties Origin properties
     * @return the OriginInner object if successful.
     */
    public OriginInner update(String resourceGroupName, String profileName, String endpointName, String originName, OriginUpdateParametersInner originUpdateProperties) {
        return updateWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName, originUpdateProperties).toBlocking().last().getBody();
    }

    /**
     * Updates an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param originUpdateProperties Origin properties
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<OriginInner> updateAsync(String resourceGroupName, String profileName, String endpointName, String originName, OriginUpdateParametersInner originUpdateProperties, final ServiceCallback<OriginInner> serviceCallback) {
        return ServiceCall.create(updateWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName, originUpdateProperties), serviceCallback);
    }

    /**
     * Updates an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param originUpdateProperties Origin properties
     * @return the observable for the request
     */
    public Observable<OriginInner> updateAsync(String resourceGroupName, String profileName, String endpointName, String originName, OriginUpdateParametersInner originUpdateProperties) {
        return updateWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName, originUpdateProperties).map(new Func1<ServiceResponse<OriginInner>, OriginInner>() {
            @Override
            public OriginInner call(ServiceResponse<OriginInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Updates an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param originUpdateProperties Origin properties
     * @return the observable for the request
     */
    public Observable<ServiceResponse<OriginInner>> updateWithServiceResponseAsync(String resourceGroupName, String profileName, String endpointName, String originName, OriginUpdateParametersInner originUpdateProperties) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (profileName == null) {
            throw new IllegalArgumentException("Parameter profileName is required and cannot be null.");
        }
        if (endpointName == null) {
            throw new IllegalArgumentException("Parameter endpointName is required and cannot be null.");
        }
        if (originName == null) {
            throw new IllegalArgumentException("Parameter originName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (originUpdateProperties == null) {
            throw new IllegalArgumentException("Parameter originUpdateProperties is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(originUpdateProperties);
        Observable<Response<ResponseBody>> observable = service.update(resourceGroupName, profileName, endpointName, originName, this.client.subscriptionId(), originUpdateProperties, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return client.getAzureClient().getPutOrPatchResultAsync(observable, new TypeToken<OriginInner>() { }.getType());
    }

    /**
     * Updates an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param originUpdateProperties Origin properties
     * @return the OriginInner object if successful.
     */
    public OriginInner beginUpdate(String resourceGroupName, String profileName, String endpointName, String originName, OriginUpdateParametersInner originUpdateProperties) {
        return beginUpdateWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName, originUpdateProperties).toBlocking().single().getBody();
    }

    /**
     * Updates an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param originUpdateProperties Origin properties
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<OriginInner> beginUpdateAsync(String resourceGroupName, String profileName, String endpointName, String originName, OriginUpdateParametersInner originUpdateProperties, final ServiceCallback<OriginInner> serviceCallback) {
        return ServiceCall.create(beginUpdateWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName, originUpdateProperties), serviceCallback);
    }

    /**
     * Updates an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param originUpdateProperties Origin properties
     * @return the observable to the OriginInner object
     */
    public Observable<OriginInner> beginUpdateAsync(String resourceGroupName, String profileName, String endpointName, String originName, OriginUpdateParametersInner originUpdateProperties) {
        return beginUpdateWithServiceResponseAsync(resourceGroupName, profileName, endpointName, originName, originUpdateProperties).map(new Func1<ServiceResponse<OriginInner>, OriginInner>() {
            @Override
            public OriginInner call(ServiceResponse<OriginInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Updates an existing CDN origin within an endpoint.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName Name of the CDN profile which is unique within the resource group.
     * @param endpointName Name of the endpoint under the profile which is unique globally.
     * @param originName Name of the origin which is unique within the endpoint.
     * @param originUpdateProperties Origin properties
     * @return the observable to the OriginInner object
     */
    public Observable<ServiceResponse<OriginInner>> beginUpdateWithServiceResponseAsync(String resourceGroupName, String profileName, String endpointName, String originName, OriginUpdateParametersInner originUpdateProperties) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (profileName == null) {
            throw new IllegalArgumentException("Parameter profileName is required and cannot be null.");
        }
        if (endpointName == null) {
            throw new IllegalArgumentException("Parameter endpointName is required and cannot be null.");
        }
        if (originName == null) {
            throw new IllegalArgumentException("Parameter originName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (originUpdateProperties == null) {
            throw new IllegalArgumentException("Parameter originUpdateProperties is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(originUpdateProperties);
        return service.beginUpdate(resourceGroupName, profileName, endpointName, originName, this.client.subscriptionId(), originUpdateProperties, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<OriginInner>>>() {
                @Override
                public Observable<ServiceResponse<OriginInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<OriginInner> clientResponse = beginUpdateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<OriginInner> beginUpdateDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<OriginInner, ErrorResponseException>(this.client.mapperAdapter())
                .register(200, new TypeToken<OriginInner>() { }.getType())
                .register(202, new TypeToken<OriginInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the PagedList&lt;OriginInner&gt; object if successful.
     */
    public PagedList<OriginInner> listByEndpointNext(final String nextPageLink) {
        ServiceResponse<Page<OriginInner>> response = listByEndpointNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<OriginInner>(response.getBody()) {
            @Override
            public Page<OriginInner> nextPage(String nextPageLink) {
                return listByEndpointNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<OriginInner>> listByEndpointNextAsync(final String nextPageLink, final ServiceCall<List<OriginInner>> serviceCall, final ListOperationCallback<OriginInner> serviceCallback) {
        return AzureServiceCall.create(
            listByEndpointNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<OriginInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OriginInner>>> call(String nextPageLink) {
                    return listByEndpointNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the PagedList&lt;OriginInner&gt; object
     */
    public Observable<Page<OriginInner>> listByEndpointNextAsync(final String nextPageLink) {
        return listByEndpointNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<OriginInner>>, Page<OriginInner>>() {
                @Override
                public Page<OriginInner> call(ServiceResponse<Page<OriginInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the PagedList&lt;OriginInner&gt; object
     */
    public Observable<ServiceResponse<Page<OriginInner>>> listByEndpointNextWithServiceResponseAsync(final String nextPageLink) {
        return listByEndpointNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<OriginInner>>, Observable<ServiceResponse<Page<OriginInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OriginInner>>> call(ServiceResponse<Page<OriginInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByEndpointNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists the existing CDN origins within an endpoint.
     *
    ServiceResponse<PageImpl<OriginInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the PagedList&lt;OriginInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<OriginInner>>> listByEndpointNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        return service.listByEndpointNext(nextPageLink, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<OriginInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OriginInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<OriginInner>> result = listByEndpointNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<OriginInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<OriginInner>> listByEndpointNextDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<OriginInner>, ErrorResponseException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<OriginInner>>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

}
